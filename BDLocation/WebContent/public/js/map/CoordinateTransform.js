var CoordinateSys = { WGS84: 0, GCJ02: 1, BD09: 2 };

function CoordinateTransform(lat, lng, crdSys) {
    this._GCJLat = 0;
    this._GCJLng = 0;
    this._WGSLat = 0;
    this._WGSLng = 0;
    this._BDLat = 0;
    this._BDLng = 0;
    this._ErrMsg = "";
    this.a = 6378245.0;
    this.ee = 0.00669342162296594323;

    if (crdSys == CoordinateSys.WGS84) {
        this._WGSLat = lat;
        this._WGSLng = lng;
    }
    else if (crdSys == CoordinateSys.GCJ02) {
        this._GCJLat = lat;
        this._GCJLng = lng;
    }
    else {
        this._BDLat = lat;
        this._BDLng = lng;
    }
};

CoordinateTransform.prototype.OutChina = function (lat, lng) {
    if (lng < 72.004 || lng > 137.8347)
        return true;
    if (lat < 0.8293 || lat > 55.8271)
        return true;
    return false;
};

CoordinateTransform.prototype.TransformLat = function (x, y) {
    var lat = -100.0 + 2.0 * x + 3.0 * y + 0.2 * y * y + 0.1 * x * y
            + 0.2 * Math.sqrt(Math.abs(x));
    lat += (20.0 * Math.sin(6.0 * x * Math.PI) + 20.0 * Math.sin(2.0 * x
            * Math.PI)) * 2.0 / 3.0;
    lat += (20.0 * Math.sin(y * Math.PI) + 40.0 * Math.sin(y / 3.0
            * Math.PI)) * 2.0 / 3.0;
    lat += (160.0 * Math.sin(y / 12.0 * Math.PI) + 320 * Math.sin(y
            * Math.PI / 30.0)) * 2.0 / 3.0;
    return lat;

}

CoordinateTransform.prototype.TransformLng = function (x, y) {
    var lng = 300.0 + x + 2.0 * y + 0.1 * x * x + 0.1 * x * y + 0.1
            * Math.sqrt(Math.abs(x));
    lng += (20.0 * Math.sin(6.0 * x * Math.PI) + 20.0 * Math.sin(2.0 * x
            * Math.PI)) * 2.0 / 3.0;
    lng += (20.0 * Math.sin(x * Math.PI) + 40.0 * Math.sin(x / 3.0
            * Math.PI)) * 2.0 / 3.0;
    lng += (150.0 * Math.sin(x / 12.0 * Math.PI) + 300.0 * Math.sin(x
            / 30.0 * Math.PI)) * 2.0 / 3.0;
    return lng;
}

CoordinateTransform.prototype.WGS84ToGCJ02 = function () {
    if (this.OutChina(this._WGSLat, this._WGSLng)) {
        this._ErrMsg = "坐标超出中国范围！";
        return false;
    }

    try {
        var dLat = this.TransformLat(this._WGSLng - 105.0, this._WGSLat - 35.0);
        var dLng = this.TransformLng(this._WGSLng - 105.0, this._WGSLat - 35.0);

        var radLat = this._WGSLat * Math.PI / 180.0;
        var magic = Math.sin(radLat);
        magic = 1 - this.ee * magic * magic;
        var sqrtMagic = Math.sqrt(magic);
        dLat = (dLat * 180.0)
            / ((this.a * (1 - this.ee)) / (magic * sqrtMagic) * Math.PI);
        dLng = (dLng * 180.0) / (this.a / sqrtMagic * Math.cos(radLat) * Math.PI);
        this._GCJLat = parseFloat(this._WGSLat) + dLat;
        this._GCJLng = parseFloat(this._WGSLng) + dLng;
    }
    catch (e) {
        this._ErrMsg = "WGS84ToGCJ02出错：" + e.message;
        return false;
    }
    return true;
}

CoordinateTransform.prototype.WGS84ToBD09 = function () {
    if (this.OutChina(this._WGSLat, this._WGSLng)) {
        this._ErrMsg = "坐标超出中国范围！";
        return false;
    }
    try {

        if (!this.WGS84ToGCJ02()) {
            return false;
        }
  
        return this.GCJ02ToBD09();
    }
    catch (e) {
        this._ErrMsg = "WGS84ToBD09出错：" + e.message;
        return false;
    }
}

CoordinateTransform.prototype.GCJ02ToWGS84 = function () {
    if (this.OutChina(this._GCJLat, this._GCJLng)) {
        this._ErrMsg = "坐标超出中国范围！";
        return false;
    }

    try {
        var dLat = this.TransformLat(this._GCJLng - 105.0, this._GCJLat - 35.0);
        var dLng = this.TransformLng(this._GCJLng - 105.0, this._GCJLat - 35.0);
        var radLat = this._GCJLat / 180.0 * Math.PI;
        var magic = Math.sin(radLat);
        magic = 1 - this.ee * magic * magic;
        var sqrtMagic = Math.sqrt(magic);
        dLat = (dLat * 180.0) / ((this.a * (1 - this.ee)) / (magic * sqrtMagic) * Math.PI);
        dLng = (dLng * 180.0) / (this.a / sqrtMagic * Math.cos(radLat) * Math.PI);
        var mgLat = dLat + parseFloat(this._GCJLat);
        var mgLng =dLng+parseFloat(this._GCJLng);
   
        this._WGSLng = 2*this._GCJLng  - mgLng;
        this._WGSLat = 2*this._GCJLat - mgLat;
    }
    catch (e) {
        this._ErrMsg = "GCJ02ToWGS84出错：" + e.message;
        return false;
    }

    return true;
}

CoordinateTransform.prototype.BD09ToGWGS84 = function () {
    if (this.OutChina(this._BDLat, this._BDLng)) {
        this._ErrMsg = "坐标超出中国范围！";
        return false;
    }
    try {
        if (!this.BD09ToGCJ02())
            return false;
        return this.GCJ02ToWGS84();
    }
    catch (e) {
        this._ErrMsg = "BD09ToGWGS84出错：" + e.message;
        return false;
    }
}

CoordinateTransform.prototype.GCJ02ToBD09 = function () {
    if (this.OutChina(this._GCJLat, this._GCJLng)) {
        this._ErrMsg = "坐标超出中国范围！";
        return false;
    }
    try {

        var x = this._GCJLng, y = this._GCJLat;
        var z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * Math.PI);
        var theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * Math.PI);
        this._BDLng = z * Math.cos(theta) + 0.0065;
        this._BDLat = z * Math.sin(theta) + 0.006;
    }

    catch (e) {
        this._ErrMsg = "GCJ02ToBD09出错：" + e.message;
        return false;
    }

    return true;
}

CoordinateTransform.prototype.BD09ToGCJ02 = function () {
    if (this.OutChina(this._BDLat, this._BDLng)) {
        this._ErrMsg = "坐标超出中国范围！";
        return false;
    }
    try {
        var x = this._BDLng - 0.0065, y = this._BDLat - 0.006;
        var z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * Math.PI);
        var theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * Math.PI);
        this._GCJLng = z * Math.cos(theta);
        this._GCJLat = z * Math.sin(theta);
    }
    catch (e) {
        this._ErrMsg = "BD09ToGCJ02出错：" + e.message;
        return false;
    }
    return true;
};

CoordinateTransform.prototype.get_GCJLat = function () {
    return this._GCJLat;
};

CoordinateTransform.prototype.get_GCJLng = function () {
    return this._GCJLng;
};

CoordinateTransform.prototype.get_WGSLat = function () {
    return this._WGSLat;
};

CoordinateTransform.prototype.get_WGSLng = function () {
    return this._WGSLng;
};

CoordinateTransform.prototype.get_BDLat = function () {
    return this._BDLat;
};

CoordinateTransform.prototype.get_BDLng = function () {
    return this._BDLng;
};

CoordinateTransform.prototype.get_ErrMsg = function () {
    return this._ErrMsg;
};
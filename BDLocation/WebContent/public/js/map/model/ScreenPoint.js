var SreenPoint = function(option){
	
	this.x = option.x;		//屏幕X坐标
	
	this.y = option.y;		//屏幕Y坐标
	
	this.sPoint = option.sPoint;		//个性化参数
	
	this.getX = function(){
		return this.x;
	};
	
	this.getY = function(){
		return this.y;
	};
};
SreenPoint.CLASS_NAME = "SreenPoint";
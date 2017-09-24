$(function() {
	getStatisticDataAndRender();
});
function getStatisticDataAndRender() {
	$.ajax({
		type : "GET",
		url : CONTEXT_PATH + "/client/overView/statistic",
		dataType : "json",
		success : function(data) {
			renderStaticOfServiceType(data.StatisticOfServiceType);
			renderStaticOfCompanyGroup(data.StatisticOfGroup);
			renderStatisticOfActiveState(data.StatisticOfActiveState);
			renderStatisticOfBindDev(data.StatisticOfBindDev);
			renderStatisticOfUserPeriod(data.StatisticOfUserPeriod);
		}
	});
}

function toCorsAccountMgt(sender) {
	var toPath = $(sender).attr('action');
	$("#secondMenuUL li a[action='" + toPath + "']").trigger('click');
}

/**
 *  var data = [
 {name : '米',value : 10,color:'#ffc000'},
 {name : '亚米',value : 15,color:'#ed7d31'},
 {name : '厘米',value : 25,color:'#5b9bd5'}
 ];

 * @param _data
 */
function renderStaticOfServiceType(_data) {
	
	var defaultData = [ {
		typeName : 'centimeter',
		name : '厘米级:0',
		value : 0
	}, {
		typeName : 'meter',
		name : '亚米级:0',
		value : 0
	}, {
		typeName : 'milevel',
		name : '米级:0',
		value : 0
	} ];
	var legendData = [];
	for ( var i = 0, l = _data.length; i < l; i++) {
		for ( var j = 0, jl = defaultData.length; j < jl; j++) {
			if (_data[i].typeName == defaultData[j].typeName) {
				defaultData[j].name = _data[i].name;
				defaultData[j].value = _data[i].value;
			}
		}
	}
	for ( var k = 0, kl = defaultData.length; k < kl; k++) {
		legendData.push(defaultData[k].name);
	}
	var myChart = echarts
			.init(document.getElementById('canvasDiv'), 'macarons');
	option = {
		title: {
            text: '',
            textStyle: {
            	color: '#333',
            	fontWeight: 'bold',
            	fontSize: 14,
            },
            padding: [0, 0, 0, 20]
        },
		legend : {
			orient : 'vertical',
			left : 'right',
			padding : [ 5, 15 ],
			data : legendData
		},
		series : [ {
			type : 'pie',
			radius : '65%',
			center : [ '45%', '45%' ],
			data : defaultData,
			itemStyle : {
				emphasis : {
					shadowBlur : 10,
					shadowOffsetX : 0,
					shadowColor : 'rgba(0, 0, 0, 0.5)'
				}
			},
			avoidLabelOverlap : false,
			label : {
				normal : {
					show : false,
					position : 'outside'
				},
				emphasis : {
					show : true,
					textStyle : {
						fontSize : '12',
						fontWeight : 'normal'
					}
				}
			},
			labelLine : {
				normal : {
					show : false
				}
			}
		} ]
	};

	myChart.setOption(option);
}

/**
 * var data = [ {name : '组别一',value : 20,color:'#a5c2d5',width:40}, {name :
 * '组别二',value : 10,color:'#cbab4f',width:40}, {name : '组别三',value :
 * 10,color:'#76a871',width:40}, {name : '组别四',value :
 * 5,color:'#9f7961',width:40}, {name : '组别五',value :
 * 5,color:'#a56f8f',width:40} ];
 * 
 * @param _data
 */
function renderStaticOfCompanyGroup(_data) {
	var dataName = [],
		dataValue = [];
	for(var i=0,l=_data.length; i<l; i++){
		dataName.push(_data[i].name);
		dataValue.push(_data[i].value);
	}
	// 基于准备好的dom，初始化echarts图表
	var myChart = echarts.init(document.getElementById('canvasDiv2'));
	option = {
		color : [ '#c12e34' ],
		tooltip : {
			trigger : 'axis',
			axisPointer : { // 坐标轴指示器，坐标轴触发有效
				type : 'line' // 默认为直线，可选为：'line' | 'shadow'
			},
			formatter : '{b}</br>数量:{c}'
		},
		grid : {
			left : '4%',
			right : '4%',
			bottom : '6%',
			top : '2%',
			containLabel : true
		},
		xAxis : [ {
			type : 'category',
			axisLine : {
				onZero : false
			},
			axisTick : {
				show : true
			},
			splitLine:false,
			inverse : true,
			data : dataName
		} ],
		yAxis : [ {
			type : 'value',
			splitNumber : 4,
			max : 60,
			min : 0,
			interval : 10,
			axisLabel : {
				formatter : function(value) {
					return value;
				}
			},
			axisLine : {
				show : true
			},
			axisTick : {
				show : true
			}
		} ],
		series : [ {
			name : '直接访问',
			type : 'bar',
			barWidth : '35',
			data : dataValue
		} ]
	};

	// 为echarts对象加载数据
	myChart.setOption(option);
}

/**
 * var data = [ {name : '已激活 40,',value : 80,color:'#eb7c30'}, {name : '未激活
 * 10,',value : 20,color:'#5a99d3'} ];
 * 
 * @param _data
 */
function renderStatisticOfActiveState(_data) {
	var defaultData = [{typeName:'unactive',name:'未激活 0',value:0},
	                   {typeName:'actived',name:'已激活 0',value:0},
	                   {typeName:'sumAccount',name:'总配额 0',value:0}];
	var legendData = [];
	for ( var i = 0, l = _data.length; i < l; i++) {
		for ( var j = 0, jl = defaultData.length; j < jl; j++) {
			if (_data[i].typeName == defaultData[j].typeName) {
				defaultData[j].name = _data[i].name;
				defaultData[j].value = _data[i].value;
			}
		}
	}
	for ( var k = 0, kl = defaultData.length; k < kl; k++) {
		legendData.push(defaultData[k].name);
	}
	
	// 基于准备好的dom，初始化echarts图表
	var myChart = echarts.init(document.getElementById('canvasDiv3'),
			'macarons');
	option = {
		title: {
	        text: '账号激活状态',
	        textStyle: {
	        color: '#333',
	        fontWeight: 'bold',
	        fontSize: 14,
	        },
	        left: 'center'
	     },
		legend : {
			orient : 'vertical',
			x : 'right',
			bottom: 20,
			padding: [0,0,0,0],
			data : legendData
		},
		series : [ {
			name : '访问来源',
			type : 'pie',
			radius : [ '45%', '60%' ],
			avoidLabelOverlap : false,
			label : {
				normal : {
					show : false,
					position : 'center'
				},
				emphasis : {
					show : true,
					textStyle : {
						fontSize : '13',
						fontWeight : 'normal'
					}
				}
			},
			labelLine : {
				normal : {
					show : false
				}
			},
			data : defaultData
		} ]
	};

	// 为echarts对象加载数据 
	myChart.setOption(option);
}

/**
 * var data = [ {name : '已绑定 20',value : 40,color:'#eb7c30'}, {name : '绑定
 * 30,',value : 60,color:'#5a99d3'} ];
 * 
 * @param data
 */
function renderStatisticOfBindDev(_data) {
	var defaultData = [{typeName:'unbind',name:'未绑定 0',value:0},
	                   {typeName:'binded',name:'已绑定 0',value:0},
	                   {typeName:'sumAccount',name:'总配额 0',value:0}];
	var legendData = [];
	for ( var i = 0, l = _data.length; i < l; i++) {
		for ( var j = 0, jl = defaultData.length; j < jl; j++) {
			if (_data[i].typeName == defaultData[j].typeName) {
				defaultData[j].name = _data[i].name;
				defaultData[j].value = _data[i].value;
			}
		}
	}
	for ( var k = 0, kl = defaultData.length; k < kl; k++) {
		legendData.push(defaultData[k].name);
	}
	// 基于准备好的dom，初始化echarts图表
	var myChart = echarts.init(document.getElementById('canvasDiv4'),
			'macarons');

	option = {
		title: {
		    text: '设备绑定账号数量',
		    textStyle: {
		    color: '#333',
		    fontWeight: 'bold',
		    fontSize: 14,
		    },
		    left: 'center'
		},
		legend : {
			orient : 'vertical',
			x : 'right',
			bottom: 20,
			padding: [0,0,0,0],
			data : legendData
		},
		series : [ {
			name : '访问来源',
			type : 'pie',
			radius : [ '45%', '60%' ],
			avoidLabelOverlap : false,
			label : {
				normal : {
					show : false,
					position : 'center'
				},
				emphasis : {
					show : true,
					textStyle : {
						fontSize : '13',
						fontWeight : 'normal'
					}
				}
			},
			labelLine : {
				normal : {
					show : false
				}
			},
			data :defaultData
		} ]
	};

	// 为echarts对象加载数据 
	myChart.setOption(option);
}
/**
 * var data = [ {name : '已到期 20,',value : 40,color:'#ffbf00'}, {name : '将到期
 * 30,',value : 60,color:'#5a99d3'}, {name : '正常 30,',value :
 * 60,color:'#eb7c30'} ];
 * 
 * @param data
 */
function renderStatisticOfUserPeriod(_data) {
	var defaultData = [{typeName:'normal',name:'正常 0',value:0},
	                   {typeName:'expired',name:'已过期 0',value:0},
	                   {typeName:'soon',name:'即将过期 0',value:0}
	                   ];
	                   
	var legendData = [];
	for ( var i = 0, l = _data.length; i < l; i++) {
		for ( var j = 0, jl = defaultData.length; j < jl; j++) {
			if (_data[i].typeName == defaultData[j].typeName) {
				defaultData[j].name = _data[i].name;
				defaultData[j].value = _data[i].value;
			}
		}
	}
	for ( var k = 0, kl = defaultData.length; k < kl; k++) {
		legendData.push(defaultData[k].name);
	}
	// 基于准备好的dom，初始化echarts图表
	var myChart = echarts.init(document.getElementById('canvasDiv5'),
			'macarons');

	option = {
		title: {
		        text: '服务账号期限',
		        textStyle: {
		        color: '#333',
		        fontWeight: 'bold',
		        fontSize: 14,
		        },
		        left: 'center'
		     },
		legend : {
			orient : 'vertical',
			x : 'right',
			bottom: 20,
			padding: [0,0,0,0],
			data : legendData
		},
		series : [ {
			name : '访问来源',
			type : 'pie',
			radius : [ '45%', '60%' ],
			avoidLabelOverlap : false,
			label : {
				normal : {
					show : false,
					position : 'center'
				},
				emphasis : {
					show : true,
					textStyle : {
						fontSize : '14',
						fontWeight : 'normal'
					}
				}
			},
			labelLine : {
				normal : {
					show : false
				}
			},
			data : defaultData
		} ]
	};

	// 为echarts对象加载数据 
	myChart.setOption(option);
}
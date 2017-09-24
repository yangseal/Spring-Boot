/** cors 账号统计  js */
$(function(){
	renderStatisticsCharts();
});

function renderStatisticsCharts(){

	  var url = CONTEXT_PATH + "/accountView/getCorsAccountStatistics";
	  $.ajax({
		  url:url,
		  async:false,
		  success:function(data){
				console.log("-------------msg---msg-------: " + JSON.stringify(data));
			  renderStatisticCompanyCorsNumber(data.companyCorsStatistic);
			  //正式、使用
			  renderCorsType(data.corsType);
			  //厘米、米、亚米
			  renderCorsPrecision(data.corsPrecision);
			  //已认证、未认证
			  renderCorsCompanyType(data.corsCompanyType);
		  }
	 });
}

//正式、试用
function renderCorsType(params){
	var myCharta = echarts.init(document.getElementById('cont_a')),
		legendData = [],
		seriesData = [];
	for(var i=0,l=params.length; i<l; i++){
		legendData.push(params[i].corsTypeName);
		var obj = {};
		obj['name'] = params[i].corsTypeName;
		obj['value'] = params[i].corsNumber;
		seriesData.push(obj);
	}
	
	optiona = {
	    title : {
	        text: '账号性质统计',
	        subtext: '',
	        x:'center',
	        textStyle: {
	            color: '#333333',
	            fontSize: '18'
	        },
	        subtextStyle: {
	            color: '#666666',
	            fontSize: '14',

	        },
	    },
	    tooltip : {
	        trigger: 'item',
	        formatter: "{b} : {c} ({d}%)"
	    },
	    legend: {
	        orient: 'vertical',
	        right: '40',
	        data: legendData
	    },
	    series : [
	        {
	            name: '',
	            type: 'pie',
	            radius : '65%',
	            center: ['50%', '60%'],
	            data:seriesData,
	            itemStyle: {
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            },
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
      			}
	        }
	    ]
	};
	myCharta.setOption(optiona);
}

//厘米、米、亚米
function renderCorsPrecision(params){
	var myCharta = echarts.init(document.getElementById('cont_b')),
		legendData = [],
		seriesData = [];
	
	for(var i=0,l=params.length; i<l; i++){
		legendData.push(params[i].deviceAccuracyName);
		var obj = {};
		obj['name'] = params[i].deviceAccuracyName;
		obj['value'] = params[i].corsNumber;
		seriesData.push(obj);
	}
	optiona = {
	    title : {
	        text: '服务类型统计',
	        subtext: '',
	        x:'center',
	        textStyle: {
	            color: '#333333',
	            fontSize: '18'
	        },
	        subtextStyle: {
	            color: '#666666',
	            fontSize: '14',

	        },
	    },
	    tooltip : {
	        trigger: 'item',
	        formatter: "{b} : {c} ({d}%)"
	    },
	    legend: {
	        orient: 'vertical',
	        right: '40',
	        data: legendData
	    },
	    series : [
	        {
	            name: '',
	            type: 'pie',
	            radius : '65%',
	            center: ['50%', '60%'],
	            data:seriesData,
	            itemStyle: {
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            },
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
      			}
	        }
	    ]
	};
	myCharta.setOption(optiona);
}

//已认证、未认证
function renderCorsCompanyType(params){
	var myCharta = echarts.init(document.getElementById('cont_c')),
		legendData = [],
		seriesData = [];

	for(var i=0,l=params.length; i<l; i++){
		legendData.push(params[i].companyTypeName);
		var obj = {};
		obj['name'] = params[i].companyTypeName;
		obj['value'] = params[i].companyNumber;
		seriesData.push(obj);
	}
	optiona = {
	    title : {
	        text: '企业性质统计',
	        subtext: '',
	        x:'center',
	        textStyle: {
	            color: '#333333',
	            fontSize: '18'
	        },
	        subtextStyle: {
	            color: '#666666',
	            fontSize: '14',

	        },
	    },
	    tooltip : {
	        trigger: 'item',
	        formatter: "{b} : {c} ({d}%)"
	    },
	    legend: {
	        orient: 'vertical',
	        right: '40',
	        data: legendData
	    },
	    series : [
	        {
	            name: '',
	            type: 'pie',
	            radius : '65%',
	            center: ['50%', '60%'],
	            data:seriesData,
	            itemStyle: {
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            },
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
      			}
	        }
	    ]
	};
	myCharta.setOption(optiona);
}

function renderStatisticCompanyCorsNumber(params){
	 var myChart = echarts.init(document.getElementById('count_d'));
	 
	 var xData = [],
	 	 activeData = [],
	 	 unactiveData = [],
	 	 corsSumData = [],
	 	 corsAccountSumNumber = 0;
	  for (var i = 0; i < params.length; i++) {
		  xData.push(params[i].companyName);
		  activeData.push(params[i].active);
		  unactiveData.push(params[i].unactive);
		  corsSumData.push(params[i].companyCorsNumber);
		  corsAccountSumNumber += (params[i].companyCorsNumber-0);
	  }
	 
option = {
  backgroundColor: "#ffffff",
  "title": {
      "text": "公司CORS账号数量统计",
      "subtext": "当前CORS账号总数：" + corsAccountSumNumber,
      x: "center",
      textStyle: {
          color: '#333333',
          fontSize: '20'
      },
      subtextStyle: {
          color: '#666666',
          fontSize: '14',

      },
  },
  "tooltip": {
      "trigger": "axis",
      "axisPointer": {
          "type": "shadow",
          textStyle: {
              color: "#333333"
          }

      },
  },
  "grid": {
      "borderWidth": 0,
      "top": 50,
      "bottom": 95,
      "left": 70,
      "right": 30,
      textStyle: {
          color: "#333333"
      }
  },
  "legend": {
      x: 'right',
      top: '50',
      left:'80%',
      textStyle: {
          color: '#333333',
      },
      "data": ['激活', '未激活']
  },
   

  "calculable": true,
  "xAxis": [{
      "type": "category",
      "axisLine": {
          lineStyle: {
              color: '#333333'
          }
      },
      "splitLine": {
          "show": false
      },
      "axisTick": {
          "show": false
      },
      "splitArea": {
          "show": false
      },
      "axisLabel": {
          "interval": 0,

      },
      "data": xData,
  }],
  "yAxis": [{
      "type": "value",
      "splitLine": {
          "show": false
      },
      "axisLine": {
          lineStyle: {
              color: '#333333'
          }
      },
      "axisTick": {
          "show": false
      },
      "axisLabel": {
          "interval": 0,

      },
      "splitArea": {
          "show": false
      },

  }],
  "dataZoom": [{
      "show": true,
      "height": 25,
      "xAxisIndex": [
          0
      ],
      bottom: 30,
      "start": 10,
      "end": 20,
      handleIcon: 'path://M306.1,413c0,2.2-1.8,4-4,4h-59.8c-2.2,0-4-1.8-4-4V200.8c0-2.2,1.8-4,4-4h59.8c2.2,0,4,1.8,4,4V413z',
      handleSize: '110%',
      handleStyle:{
          color:"#666666",
          
      },
         textStyle:{
          color:"#000"},
         borderColor:"#90979c"
      
      
  }, {
      "type": "inside",
      "show": true,
      "height": 15,
      "start": 1,
      "end": 35
  }],
  "series": [{
          "name": "激活",
          "type": "bar",
          "stack": "总量",
          "barMaxWidth": 30,
          "barGap": "10%",
          "itemStyle": {
              "normal": {
                  "color": "rgba(255,144,128,1)",
                  "label": {
                      "show": true,
                      "textStyle": {
                          "color": "#fff"
                      },
                      "position": "insideTop",
                      formatter: function(p) {
                          return p.value > 0 ? (p.value) : '';
                      }
                  }
              }
          },
          "data": activeData //[709,1917, 2455,2610,1719,1433,1544,3285,5208,3372,2484,4078],
      },

      {
          "name": "未激活",
          "type": "bar",
          "stack": "总量",
          "itemStyle": {
              "normal": {
                  "color": "rgba(0,191,183,1)",
                  "barBorderRadius": 0,
                  "label": {
                      "show": true,
                      "position": "top",
                      formatter: function(p) {
                          return p.value > 0 ? (p.value) : '';
                      }
                  }
              }
          },
          "data": unactiveData //[ 327, 1776,507,1200,800,482,204,1390,1001,951,381,220]
      }, {
          "name": "总数",
          "type": "line",
          "stack": "总量",
          symbolSize:10,
          symbol:'circle',
          "itemStyle": {
              "normal": {
                  "color": "rgba(255,0,255,1)",
                  "barBorderRadius": 0,
                  "label": {
                      "show": true,
                      "position": "top",
                      formatter: function(p) {
                          return p.value > 0 ? (p.value) : '';
                      }
                  }
              }
          },
          "data": corsSumData //[1036,3693,2962,3810,2519,1915,1748,4675,6209,4323,2865,4298]
      },
  ]
};

  myChart.setOption(option);

}

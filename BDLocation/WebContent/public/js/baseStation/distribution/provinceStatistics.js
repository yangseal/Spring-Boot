/** 基本分布 概况  js */
$(function(){
	renderDistributeCityMap();
	renderDistributeMap();
});

function renderDistributeCityMap(){
	  var myChart = echarts.init(document.getElementById('cityMain'));
	  var _pList = [],
	      _xAxisData = [],
	      _dataChecked = [],
	      _dataCheckedS = [],
	      _dataUnchecked = [],
	      _dataUncheckedS = [],
	  	  baseStationSumNumber = 0;
	      
	      
	  
	  var url = CONTEXT_PATH + "/baseStation/distribution/getBaseStationCitys";
	  $.ajax({
		  url:url,
		  async:false,
		  success:function(data){
				//console.log("-------------msg---msg-------: " + JSON.stringify(data));
				for(var i=0,l=data.length; i<l; i++){
					_pList.push(data[i].oamAreaName);
					if(i%2 != 0){
						_xAxisData.push("\n"+data[i].oamAreaName);
					}else{
						_xAxisData.push(data[i].oamAreaName);
					}
					_dataChecked.push(data[i].checked);
					_dataUncheckedS.push(data[i].unchecked);
					if(data[i].unchecked !=0){
						_dataUnchecked.push(data[i].unchecked);
					}else{
						_dataUnchecked.push("-");
					}
					baseStationSumNumber += ((data[i].checked-0)+(data[i].unchecked-0));
				}
		  }
	 });

	  var dataMap = {};
    function dataFormatter(obj) {
       var pList = _pList; //['北京','天津','河北','山西','内蒙古','辽宁','吉林','黑龙江','上海','江苏','浙江','安徽','福建','江西','山东','河南','湖北','湖南','广东','广西','海南','重庆','四川','贵州','云南','西藏','陕西','甘肃','青海','宁夏','新疆'];
       var temp;
       for (var year = 2002; year <= 2002; year++) {
          var max = 0;
          var sum = 0;
          temp = obj[year];
          for (var i = 0, l = temp.length; i < l; i++) {
             max = Math.max(max, temp[i]);
             sum += temp[i];
             obj[year][i] = {
                name : pList[i],
                value : temp[i]
             };
          }
          obj[year + 'max'] = Math.floor(max / 100) * 100;
          obj[year + 'sum'] = sum;
       }
       return obj;
    }

    dataMap.dataChecked = dataFormatter({
     2002: _dataChecked//[82.44,84.21,956.84,197.8,374.69,590.2,446.17,474.2,79.68,1110.44,685.2,783.66,664.78,535.98,1390,1288.36,707,847.25,1015.08,601.99,222.89,317.87,1047.95,281.1,463.44,39.75,282.21,215.51,47.31,52.95,305]
    });

    dataMap.dataUnchecked = dataFormatter({
      2002: _dataUnchecked//[1249.99,1069.08,2911.69,1134.31,754.78,2609.85,943.49,1843.6,2622.45,5604.49,4090.48,1337.04,2036.97,941.77,5184.98,2768.75,1709.89,1523.5,6143.4,846.89,148.88,958.87,1733.38,481.96,934.88,32.72,1007.56,501.69,144.51,153.06,603.15]
    });
    dataMap.dataUncheckedS= dataFormatter({
        2002: _dataUncheckedS//[1249.99,1069.08,2911.69,1134.31,754.78,2609.85,943.49,1843.6,2622.45,5604.49,4090.48,1337.04,2036.97,941.77,5184.98,2768.75,1709.89,1523.5,6143.4,846.89,148.88,958.87,1733.38,481.96,934.88,32.72,1007.56,501.69,144.51,153.06,603.15]
      });
    option = {
       baseOption: {
          timeline: {
          	show:false,
          },
          title: {
              left:'center',
              subtext: ''
          	   
          },
          tooltip: {},
          color:['#2BD56F','#D52B2B'],
          legend: {
             x: 'right',
             left:'75%',
             top:'5',
             data: ['已验收','未验收']
          },
          calculable : true,
          grid: {
             top: 80,
             left: 50,
             right: 50,
             bottom: 100,
             containLabel: true
          },
          xAxis: [
             {
                'type':'category',
                'axisLabel':{'interval':0},
                'data':_xAxisData, //['北京','\n天津','河北','\n山西','内蒙古','\n辽宁','吉林','\n黑龙江','上海','\n江苏','浙江','\n安徽','福建','\n江西','山东','\n河南','湖北','\n湖南','广东','\n广西','海南','\n重庆','四川','\n贵州','云南','\n西藏','陕西','\n甘肃','青海','\n宁夏','新疆'],
                splitLine: {show: true}
             }
          ],
          yAxis: [
             {
                type: 'value',
                name: '基站数（座）',
                max: 15
             }
          ],
          series: [
              {name: '已验收', type: 'bar'},
              {name: '未验收', type: 'bar'},
             {
                name: '完成情况',
                type: 'pie',
                center: ['75%', '35%'],
                radius: '28%',
                label : {
    				normal : {
    					show : false,
    					position : 'outside'
    				},
    				emphasis : {
    					show : true,
    					textStyle : {
    						fontSize : '15',
    						fontWeight : 'normal'
    					}
    				}
    			}
             }
          ]
       },
       options: [
          {
             title: {
          	   "text": 'CORS基站城市分布统计',
          	   "subtext": "当前CORS基站总数：" +baseStationSumNumber,
          	   x: "center",
          	   textStyle: {
          	       color: '#333333',
          	       fontSize: '20'
          	   },
          	   subtextStyle: {
          	       color: '#666666',
          	       fontSize: '14',

          	   }
             },
             series: [
				 {
				    name: '已验收',
				    type: 'bar',
				    stack: '总量',
				    barWidth : 17,//柱图宽度
				    label: {
				        normal: {
				            show: true,
				            position: 'insideRight'
				        }
				    },
				    data: dataMap.dataChecked['2002']
				},     
				{
				    name: '未验收',
				    type: 'bar',
				    stack: '总量',
				    barWidth : 17,//柱图宽度
				    label: {
				        normal: {
				            show:true,
				            position: 'insideRight'
				        }
				    },
				    data: dataMap.dataUnchecked['2002']
				},{
					data: [
		                   {name: '已验收', value: dataMap.dataChecked['2002sum']},
		                   {name: '未验收', value: dataMap.dataUncheckedS['2002sum']}
		                ]	
				}
             ]
          }
       ]
    };
    
    myChart.setOption(option);
	 
}

function renderDistributeMap(){
	  var myChart = echarts.init(document.getElementById('provinceMain'));
	  var _pList = [],
	      _xAxisData = [],
	      _dataChecked = [],
	      _dataUnchecked = [],
	      _dataUncheckedS=[],
	  	  baseStationSumNumber = 0;
	      
	      
	  
	  var url = CONTEXT_PATH + "/baseStation/distribution/getBaseStationProvince";
	  $.ajax({
		  url:url,
		  async:false,
		  success:function(data){
				//console.log("-------------msg---msg-------: " + JSON.stringify(data));
				for(var i=0,l=data.length; i<l; i++){
					_pList.push(data[i].oamAreaName);
					if(i%2 != 0){
						_xAxisData.push("\n"+data[i].oamAreaName);
					}else{
						_xAxisData.push(data[i].oamAreaName);
					}
					_dataChecked.push(data[i].checked);
					_dataUncheckedS.push(data[i].unchecked);
					if(data[i].unchecked!=0){
					   _dataUnchecked.push(data[i].unchecked);
					}else{
						_dataUnchecked.push("-");
					}
					if((data[i].checked-0)+(data[i].unchecked-0)){
						baseStationSumNumber += 1;
					}
					
				}
				
		  }
	 });

	  var dataMap = {};
      function dataFormatter(obj) {
         var pList = _pList; //['北京','天津','河北','山西','内蒙古','辽宁','吉林','黑龙江','上海','江苏','浙江','安徽','福建','江西','山东','河南','湖北','湖南','广东','广西','海南','重庆','四川','贵州','云南','西藏','陕西','甘肃','青海','宁夏','新疆'];
         var temp;
         for (var year = 2002; year <= 2002; year++) {
            var max = 0;
            var sum = 0;
            temp = obj[year];
            for (var i = 0, l = temp.length; i < l; i++) {
               max = Math.max(max, temp[i]);
               sum += temp[i];
               obj[year][i] = {
                  name : pList[i],
                  value : temp[i]
               };
            }
            obj[year + 'max'] = Math.floor(max / 100) * 100;
            obj[year + 'sum'] = sum;
         }
         return obj;
      }

      dataMap.dataChecked = dataFormatter({
       2002: _dataChecked//[82.44,84.21,956.84,197.8,374.69,590.2,446.17,474.2,79.68,1110.44,685.2,783.66,664.78,535.98,1390,1288.36,707,847.25,1015.08,601.99,222.89,317.87,1047.95,281.1,463.44,39.75,282.21,215.51,47.31,52.95,305]
      });

      dataMap.dataUnchecked = dataFormatter({
        2002: _dataUnchecked//[1249.99,1069.08,2911.69,1134.31,754.78,2609.85,943.49,1843.6,2622.45,5604.49,4090.48,1337.04,2036.97,941.77,5184.98,2768.75,1709.89,1523.5,6143.4,846.89,148.88,958.87,1733.38,481.96,934.88,32.72,1007.56,501.69,144.51,153.06,603.15]
      });
      dataMap.dataUncheckedS = dataFormatter({
        2002: _dataUncheckedS
      });
      option = {
         baseOption: {
            timeline: {
            	show:false,
            },
            title: {
                left:'center',
                subtext: ''
            	   
            },
            tooltip: {},
            color:['#2BD56F','#D52B2B'],
            legend: {
               x: 'right',
               left:'75%',
               top:'5',
               data: ['已验收','未验收']
            },
            calculable : true,
            grid: {
            	 top: 80,
                 bottom: 100,
                 containLabel:true
            },
            xAxis: [
               {
                  'type':'category',
                  'axisLabel':{'interval':0},
                  'data':_xAxisData, //['北京','\n天津','河北','\n山西','内蒙古','\n辽宁','吉林','\n黑龙江','上海','\n江苏','浙江','\n安徽','福建','\n江西','山东','\n河南','湖北','\n湖南','广东','\n广西','海南','\n重庆','四川','\n贵州','云南','\n西藏','陕西','\n甘肃','青海','\n宁夏','新疆'],
                  splitLine: {show: true}
               }
            ],
            yAxis: [
               {
                  type: 'value',
                  name: '基站数（座）',
                  max: 35
               }
            ],
            series: [
                {name: '已验收', type: 'bar'},
                {name: '未验收', type: 'bar'},
               {
                  name: '完成情况',
                  type: 'pie',
                  center: ['75%', '35%'],
                  radius: '28%',
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
         },
         options: [
            {
               title: {
            	   "text": 'CORS基站各省份分布统计',
            	   "subtext": "当前已覆盖全国：" +baseStationSumNumber + " 个省市",
            	   x: "center",
            	   textStyle: {
            	       color: '#333333',
            	       fontSize: '20'
            	   },
            	   subtextStyle: {
            	       color: '#666666',
            	       fontSize: '14',
            	   }
               },
               series: [
	          			{
	          			name: '已验收',
	          			type: 'bar',
	          		    stack: '总量',
	          			barWidth : 25,//柱图宽度
	          			label: {
	          				  normal: {
	          				    show: true,
	          				    position: 'inside'
	          				     }
	          				    },
	          				 data: dataMap.dataChecked['2002']
	          				},     
          				{
          				   name: '未验收',
          				   type: 'bar',
          				   stack: '总量',
          				   barWidth : 25,//柱图宽度
          				   label: {
          				        normal: {
          				          show:true,
          				          position: 'insideRight'
          				        }
          				    },
          				    data: dataMap.dataUnchecked['2002']
          				},{
          					data: [
          		                   {name: '已验收', value: dataMap.dataChecked['2002sum']},
          		                   {name: '未验收', value: dataMap.dataUncheckedS['2002sum']}
          		                ]	
          			}
                ]
            }
         ]
      };
      myChart.setOption(option);
}

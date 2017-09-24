 $(function () {
  var navLi=$(".header .nav li");
  navLi.mouseover(function () {
    $(this).find("a").addClass("current");
    $(this).find(".box").stop().slideDown(200);
  })
  navLi.mouseleave(function(){
    $(this).find("a").removeClass("current");
    $(this).find(".box").stop().slideUp(200);
  })
  navLi.find(".box_top").click(function(){
    navLi.find("a").removeClass("current");
    navLi.find(".box").stop().slideUp(200);
  })
})
 // 二三级
 $(function(){
  function switchTab(liDe, divDe,elentDe,classDe,timeDe){
    liDe.each(function(i){
      var liDeThis = $(this);
      liDeThis.bind(elentDe,function(){
        liDe.removeClass();
        divDe.stop().hide().animate({'opacity':0},0);
        $(this).addClass(classDe);
        divDe.eq(i).show().animate({'opacity':1},timeDe);
      });
    });
  }
  switchTab($("#tab").find(".tab_col li"), $("#tab").find(".turn"),"mouseenter","libg",300);
});
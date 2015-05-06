/**
 * Created by Administrator on 2015/1/27.
 */
$(function(){
    $('.menu-lev1 > ul > li').on('click', function (e) {
        var href = $(this).find("a").attr("href");
        window.location.href = href;
    });


    $('.tree li:has(ul)').addClass('parent_li').find(' > span').attr('title', 'Collapse this branch');
    $('.root-lev1').find(' > ul > li').hide('fast');
    //.find(' > i').addClass('icon-plus-sign').removeClass('icon-minus-sign');
    $('.root-lev1 > span').find(' > i').addClass('icon-plus-sign').removeClass('icon-minus-sign');

    $('.tree li.parent_li > span').on('click', function (e) {
        var children = $(this).parent('li.parent_li').find(' > ul > li');
        if (children.is(":visible")) {
            children.hide('fast');
            $(this).attr('title', 'Expand this branch').find(' > i').addClass('icon-plus-sign').removeClass('icon-minus-sign');
        } else {
            children.show('fast');
            $(this).attr('title', 'Collapse this branch').find(' > i').addClass('icon-minus-sign').removeClass('icon-plus-sign');
        }
        e.stopPropagation();
    });
});

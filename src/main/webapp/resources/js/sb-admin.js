
$(function() {
    $('#cust_edit').click(function(){
    var id = $('#ad_id').val();
    var ad_name = $('#ad_name').val();
    var ad_mail = $('#ad_mail').val();
    var ad_phone = $('#ad_phone').val();
    var ad_address = $('#ad_address').val();
    var ad_city_region = $('#ad_city_region').val();
    var ad_cc_number = $('#ad_cc_number').val();
    
    $.ajax({
        type: "GET",
        url: "editCustomer",
        data: { 'id': id, 'name': ad_name, 'mail': ad_mail, 'phone': ad_phone, 'address': ad_address 
            ,'city': ad_city_region ,'num': ad_cc_number }, 
        success: function () {
        }
//        ,error: function (err) {
//            alert(err);
//        }
//        });
        })
    });
    
    $('#cust_del').click(function(){
        alert("deleted");
    });
});

function custEdit(){
    alert("GO");
    $('.gradeX').click(function(){
        var id = $(this).attr('id');
        $.ajax({
        type: "GET",
        url: "cusdetail",
        data: { 'id': id }, 
        success: function () {
            alert('gradeX');
        }
        })
   });
}

//$(function() {
//    $('#ad_insert').click(function(){
//        var id = "112233";
//        id = $('#ad_text').val();
//        $.ajax({
//            type: "GET",
//            url: "showSODetail",
//            data: { 'id': id },
//            success: function () {
//                $("#ad_edit").css('display','none');
//                alert(id);
//            },
//            error: function (err) {
//                alert(err);
//            }
//        })
//    });
//});

$(function() {
    $('#side-menu').metisMenu();
    $('#dataTables-example').dataTable();
    $('#f_logout').click(function() {
    	$('#f_logout').submit();
    });
});

//Loads the correct sidebar on window load
$(function() {

    $(window).bind("load", function() {
        if ($(this).width() < 768) {
            $('div.sidebar-collapse').addClass('collapse');
        } else {
            $('div.sidebar-collapse').removeClass('collapse');
        }
    });
});

//Collapses the sidebar on window resize
$(function() {

    $(window).bind("resize", function() {
        if ($(this).width() < 768) {
            $('div.sidebar-collapse').addClass('collapse');
        } else {
            $('div.sidebar-collapse').removeClass('collapse');
        }
    });
});
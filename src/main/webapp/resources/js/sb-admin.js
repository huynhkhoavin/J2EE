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




    function addRow(tableID) {
        var table = document.getElementById(tableID);
        var rowCount = table.rows.length;
        var row = table.insertRow(rowCount);
        var cell1 = row.insertCell(0);
        var element1 = document.createElement("input");
        element1.type = "checkbox";
        element1.name="chkbox[]";
        cell1.appendChild(element1);
        var cell2 = row.insertCell(1);
        cell2.innerHTML = rowCount;
        var cell3 = row.insertCell(2);
        var element2 = document.createElement("input");
        element2.type = "text";
        element2.name = "txtbox[]";
        cell3.appendChild(element2);
    }
    
    function deleteRow(tableID) {
        try {
        var table = document.getElementById(tableID);
        var rowCount = table.rows.length;
        if(table.rows.length>0)
        table.deleteRow(table.rows.length-1);
        }catch(e) {
                alert(e);
        }
     }
     

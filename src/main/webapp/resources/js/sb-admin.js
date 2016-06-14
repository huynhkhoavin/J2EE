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

// Customer Edit
$(document).ready(function() {
    $('#cus_edit').click(function() {
        var id = $('#cus_id').val();
        var ad_name = $('#cus_name').val();
        var ad_mail = $('#cus_mail').val();
        var ad_phone = $('#cus_phone').val();
        var ad_address = $('#cus_address').val();
        var ad_city = $('#cus_city_region').val();
        var ad_num = $('#cus_cc_number').val();

        $.ajax({
            type: "GET",
            url: "editCustomer",
            data: {
                'id': id,
                'name': ad_name,
                'mail': ad_mail,
                'phone': ad_phone,
                'address': ad_address,
                'city': ad_city,
                'num': ad_num
            },
            success: function() {
                alert("OK Customer");
            },
            error: function(){
              alert('error!');
            }

        })
    });

    $('#cust_del').click(function() {
        alert("deleted");
    });
});

// Member Edit
$(document).ready(function() {
    $('#mem_edit').click(function() {
        var id = $('#mem_id').val();
        var name = $('#mem_name').val();
        var username = $('#mem_username').val();
        var status = $('#mem_status').val();
        var role = $('#mem_role').val();

        $.ajax({
            type: "GET",
            url: "editMember",
            data: { 'id': id, 'name': name, 'username': username, 'status': status, 'role': role },
            success: function() {
                alert("Ok Member");
            }
        })
    });

    $('#mem_del').click(function() {
        alert("deleted");
    });
});

// Category Edit
$(document).ready(function() {
    $('#cat_edit').click(function() {
        var id = $('#cat_id').val();
        var name = $('#cat_name').val();

        $.ajax({
            type: "GET",
            url: "editCategory",
            data: { 'id': id, 'name': name },
            success: function() {
                alert("Ok Category");
            }
        })
    });

    $('#cat_del').click(function() {
        alert("deleted");
    });
});

// Product Edit
$(document).ready(function() {
    $('#pro_edit').click(function() {
        var id = $('#pro_id').val();
        var name = $('#pro_name').val();
        var price = $('#pro_price').val();
        var description = $('#pro_description').val();
        // var last_date = $('#pro_last_date').val();
        // var category = $('#pro_category').val();

        $.ajax({
            type: "GET",
            url: "editOrder",
            data: { 'id': id, 'name': name, 'price': price, 'desc': description },
            // 'date': last_date, 'cat': category}, 
            success: function() {
                alert("Ok Product");
            }
        })
    });

    $('#pro_del').click(function() {
        alert("deleted");
    });
});

// Order Edit
$(document).ready(function() {
    $('#ord_edit').click(function() {
        var id = $('#ord_id').val();
        var product = $('#ord_product').val();
        var custOrder = $('#ord_customerOrder').val();
        var quantity = $('#ord_quantity').val();

        $.ajax({
            type: "GET",
            url: "editOrder",
            data: { 'id': id, 'prod': product, 'order': custOrder, 'num': quantity },
            success: function() {
                alert("Ok Order");
            }
        })
    });

    $('#ord_del').click(function() {
        alert("deleted");
    });
});
//function custEdit(){
//    alert("GO");
//    $('.gradeX').click(function(){
//        var id = $(this).attr('id');
//        $.ajax({
//        type: "GET",
//        url: "cusdetail",
//        data: { 'id': id }, 
//        success: function () {
//            alert('gradeX');
//        }
//        })
//   });
//}



//
//    function addRow(tableID) {
//        var table = document.getElementById(tableID);
//        var rowCount = table.rows.length;
//        var row = table.insertRow(rowCount);
//        var cell1 = row.insertCell(0);
//        var element1 = document.createElement("input");
//        element1.type = "checkbox";
//        element1.name="chkbox[]";
//        cell1.appendChild(element1);
//        var cell2 = row.insertCell(1);
//        cell2.innerHTML = rowCount;
//        var cell3 = row.insertCell(2);
//        var element2 = document.createElement("input");
//        element2.type = "text";
//        element2.name = "txtbox[]";
//        cell3.appendChild(element2);
//    }
//    
//    function deleteRow(tableID) {
//        try {
//        var table = document.getElementById(tableID);
//        var rowCount = table.rows.length;
//        if(table.rows.length>0)
//        table.deleteRow(table.rows.length-1);
//        }catch(e) {
//                alert(e);
//        }
//     }

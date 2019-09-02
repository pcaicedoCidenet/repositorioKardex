$(document).ready(function(){
    $('.table .eBtn').on('click', function(event){
    	event.preventDefault();
    	var href = $(this).attr('href');
        $.get(href,function(producto,status){
            $('.myForm #id').val(producto.productid);
            $('.myForm #name').val(producto.productname);
            $('.myForm #price').val(producto.productprice);
            $('.myForm #category').val(producto.productcategory);
        });

        $('.myForm #exampleModal').modal();
    });

    $('.nBtn').on('click', function(event){

        $('.myNewForm #name').val();
        $('.myNewForm #price').val();
        $('.myNewForm #category').val();
        $('.myNewForm #newProductModal').modal();
    });

    $('.dBtn').on('click', function(event){
        event.preventDefault();
        var href = $(this).attr('href');
        $('#sellModal #sellRef').attr('href',href);
        $('#sellModal').modal();
    });

    $('input').on('blur', function() {
        if ($("#myNewForm").valid()) {
                  $('#saveNewBtn').prop('disabled', false);
        } else {
                  $('#saveNewBtn').prop('disabled', 'disabled');
        }

        if ($("#myForm").valid()) {
                  $('#saveUpdateBtn').prop('disabled', false);
        } else {
                  $('#saveUpdateBtn').prop('disabled', 'disabled');
        }
    });

    $("#myNewForm").validate({
            rules: {
                name: {
                    required: true,
                    minlength: 4
                },
                price: {
                    required: true,
                    minlength: 4,
                    digits: true
                },
                category: {
                    required: true,
                    minlength: 4
                }
            }
    });

    $("#myForm").validate({
            rules: {
                name: {
                    required: true,
                    minlength: 4
                },
                price: {
                    required: true,
                    minlength: 4,
                    digits: true
                },
                category: {
                    required: true,
                    minlength: 4
                }
            }
    });
});

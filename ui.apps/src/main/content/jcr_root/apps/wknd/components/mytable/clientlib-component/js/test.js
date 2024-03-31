$(document).ready(function(){
    var resourcePath = $("input[name=resourcePath]").val();
    console.log("hello abc");
        $.ajax({
            type: 'GET',
            // this path represents the resource type which is registered within the servlet
            url: resourcePath+'.json',
            data: {
            'resourcePath':resourcePath//key value (query parameter)
            },
            success: function (data) {
               const obj = JSON.parse(data);
               var data = [];
               for(var i in obj) {
                   data.push(obj[i]);
               }
               console.log(data);
               var element = $(".mytablecomponent .tableheading");
               var headings = $(element).children('th');
               var index=0;
               $(headings).each(function() {
                        var heading = data[index];
                        $(this).text(heading);
                        index++;
               });
               var data = [];

            },
            error: function(bla) {
                alert('error');
            }
        });
});
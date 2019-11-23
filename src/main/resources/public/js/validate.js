$(document).ready(function() {
  //sighting form validation
  $("form[name='sightingsForm']").validate({
    rules: {
      wildlifeName: "required",
      rangerName: "required",
      location: "required",
    },
    messages:{
    wildlifeName:"Wildlife category must be specified",
    rangerName:"Please indicate the rangers name",
    location:"Location is required"
    },
     submitHandler: function(form) {
          form.submit();
        }
  });

});

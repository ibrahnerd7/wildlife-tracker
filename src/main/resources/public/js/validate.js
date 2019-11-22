$(document).ready(function() {
  //hero form validation
  $("form[name='heroesForm']").validate({
    rules: {
      heroName: "required",
      heroAge: {
        required: true,
        number: true
      },
      heroWeakness: "required",
      heroStrength: "required",
      squadName: "required"
    }
  });

  $("form[name='squadForm']").validate({
    rules: {
      squadName: "required",
      squadMaxSize: {
        required: true,
        number: true
      },
      squadCause: "required"
    },
    submitHandler: function(form) {
      form.submit();
    }
  });
});

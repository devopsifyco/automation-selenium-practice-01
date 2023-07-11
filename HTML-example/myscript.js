$(function() {
  //today=new Date(1000*today);
  var dateFormat = "mm/dd/yy",
    from = $("#from_filter")
    .datepicker({
      defaultDate: "+0w",
      changeMonth: true,
      changeYear: true,
      numberOfMonths: 1
    })
    .on("change", function() {
      to.datepicker("option", "minDate", getDate(this));
    }),
    to = $("#to_filter").datepicker({
      defaultDate: "+0w",
      changeMonth: true,
      changeYear: true,
      numberOfMonths: 1
    })

    .on("change", function() {
      from.datepicker("option", "maxDate", getDate(this));
    });

  function getDate(element) {
    var date;
    try {
      date = $.datepicker.parseDate(dateFormat, element.value);
    } catch (error) {
      date = NULL;
    }

    return date;
  }

  $('.to_icon').click(function() {
    $('#to_filter').datepicker("show");
  });
  $('.from_icon').click(function() {
    $('#from_filter').datepicker("show");
  });


    $( "#datepickericon" ).datepicker({
      showOn: "button",
      buttonImage: "src/main/resources/calendarIcon.jpg",
      buttonImageOnly: true,
      buttonText: "Select date"
    });


    var dateFormat = "mm/dd/yy",
      from = $( "#from" ).datepicker({
          showWeek: true,
          firstDay: 1,
          defaultDate: "+1w",
          changeMonth: true,
          changeYear: true,
          numberOfMonths: 2
        })

        .on( "change", function() {
          to.datepicker( "option", "minDate", getDate( this ) );
        }),
      to = $( "#to" ).datepicker({
        showWeek: true,
        firstDay: 1,
        defaultDate: "+1w",
        changeMonth: true,
        changeYear: true,
        numberOfMonths: 2
      })
      .on( "change", function() {
        from.datepicker( "option", "maxDate", getDate( this ) );
      });
    $( "#formatdate" ).on( "change", function() {
      $( "#from" ).datepicker( "option", "dateFormat", $( this ).val() );
      $( "#to" ).datepicker( "option", "dateFormat", $( this ).val() );
    });
    function getDate( element ) {
      var date;
      try {
        date = $.datepicker.parseDate( dateFormat, element.value );
      } catch( error ) {
        date = null;
      }
      return date;
    }
    var mydiv = document.getElementById('birthday');
            console.log(mydiv.innerHTML);
            // Hello Javascript <span style="display:none;"> 2020</span>

            console.log(mydiv.textContent);
            // Hello Javascript  2020

            console.log(mydiv.innerText);
            // Hello Javascript
  });
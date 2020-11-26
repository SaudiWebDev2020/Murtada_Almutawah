// console.log("Test");

$(document).ready(function () {
  $("p:first-child").click(function () {
    $(this).before('<a href="#">Hello</a>');
  });
  $(".hide").click(function () {
    $("p:first-child").hide();
    $(".show").removeAttr("disabled");
    $(".hide").attr("disabled", true);
  });
  $(".show").click(function () {
    $("p:first-child").show();
    // $(".hide").attr("disabled");
    $(".show").attr("disabled", true);
    $(".hide").removeAttr("disabled");
  });
  $(".toggle").click(function () {
    $("p:first-child").toggle();
    // console.log("Test");
    // console.log($(".hide").attr("disabled"));
    // console.log($(".show").attr("disabled") == "disabled");
    // console.log($("p:first-child"));

    if ($("p").css("display") == "none") {
      $(".show").attr("disabled", false);
      $(".hide").attr("disabled", true);
    } else {
      $(".show").attr("disabled", true);
      $(".hide").attr("disabled", false);
    }
  });
  $(".change-text").click(function () {
    $("p:first-child").text($(this).val());
  });
  $(".add-class").click(function () {
    $(" p:first-child").addClass("red");
  });
  $(".remove-class").click(function () {
    $(" p:first-child").removeClass("red");
  });
  $(".toggle-class").click(function () {
    $(" p:first-child").toggleClass("red");
  });

  $("button").click(function () {
    $("#text").text($(this).text());
    $("#val").text($(this).val());
    $("#html").html(
      //function () {
      //   var emphasis = "<em>" + $("p").length + " paragraphs!</em>";
      //   return "All new content for " + emphasis + "";
      // }
      $(this)[0].outerHTML
    );
    // console.log($("p"));
    // console.log($(this).html());
    // console.log($(this)[0].outerHTML);
  });
});

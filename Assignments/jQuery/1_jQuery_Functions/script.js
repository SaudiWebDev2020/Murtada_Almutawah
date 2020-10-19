$(document).ready(function () {
  $(".hide").click(function () {
    $("p:first-child").hide();
    $(".show").attr("disabled", false);
    $(".hide").attr("disabled", true);
  });
  $(".show").click(function () {
    $("p:first-child").show();
    // $(".hide").attr("disabled");
    $(".show").attr("disabled", true);
    $(".hide").attr("disabled", false);
  });
  $(".toggle").click(function () {
    $("p:first-child").toggle();
  });
  $(".change-text").click(function () {
    $("p:first-child").text($(this).val());
  });

  $("button").click(function () {
    $("#text").text($(this).text());
    $("#val").text($(this).val());
    $("#html").html(function () {
      var emphasis = "<em>" + $("p").length + " paragraphs!</em>";
      return "<p>All new content for " + emphasis + "</p>";
    });
    console.log($("p"));
  });
});

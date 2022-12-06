function detailCommFunc(evt, detailCommName) {
  var i, t_tabcontent, t_tablinks;
  t_tabcontent = document.getElementsByClassName("detailComm_tabcontent");
  for (i = 0; i < t_tabcontent.length; i++) {
    t_tabcontent[i].style.display = "none";
  }
  t_tablinks = document.getElementsByClassName("t_btn_tablinks");
  for (i = 0; i < t_tablinks.length; i++) {
    t_tablinks[i].className = t_tablinks[i].className.replace(" active_t", "");
  }
  document.getElementById(detailCommName).style.display = "block";
  evt.currentTarget.className += " active_t";
}

// Get the element with id="defaultOpen" and click on it
document.getElementById("t_defaultOpen").click();
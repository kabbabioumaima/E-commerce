/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function produitFunc(evt, produitName) {
  var i, t_tabcontent, t_tablinks;
  t_tabcontent = document.getElementsByClassName("produit_tabcontent");
  for (i = 0; i < t_tabcontent.length; i++) {
    t_tabcontent[i].style.display = "none";
  }
  t_tablinks = document.getElementsByClassName("t_btn_tablinks");
  for (i = 0; i < t_tablinks.length; i++) {
    t_tablinks[i].className = t_tablinks[i].className.replace(" active_t", "");
  }
  document.getElementById(produitName).style.display = "block";
  evt.currentTarget.className += " active_t";
}

// Get the element with id="defaultOpen" and click on it
document.getElementById("t_defaultOpen").click();


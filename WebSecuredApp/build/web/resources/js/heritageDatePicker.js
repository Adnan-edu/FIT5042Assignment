/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function() {
   $(".datepicker").datepicker({
      dateFormat: 'dd MM, yy',
      changeMonth: true,
      changeYear: true,
      yearRange: "1960:2017"
   });
});
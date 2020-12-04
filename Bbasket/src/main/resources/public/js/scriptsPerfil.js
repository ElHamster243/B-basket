
function editarTexto(label, btn)
{
  
  
  if (document.getElementById(label).disabled == false){
    if(document.getElementById(label).value!=""){
      alert("Su nuevo "+document.getElementById(label).name+" será *"+document.getElementById(label).value+"* .");
    }
    document.getElementById(btn).textContent = 'Editar';
    document.getElementById(label).disabled = true;
    document.getElementById(label).style.backgroundColor = 'white';
  }else{
    document.getElementById(btn).textContent = 'Guardar';
    document.getElementById(label).disabled = false;
    document.getElementById(label).style.borderColor = '#01EB7D';
    document.getElementById(label).focus();
    document.getElementById(label).style.backgroundColor = '#01EB7D';
    
  }
}
function permite(elEvento, permitidos) {
  // Variables que definen los caracteres permitidos
  var numeros = "0123456789";
  var caracteres = " abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
  var numeros_caracteres = numeros + caracteres;
  var teclas_especiales = [8, 37, 39, 46];
  // 8 = BackSpace, 46 = Supr, 37 = flecha izquierda, 39 = flecha derecha


  // Seleccionar los caracteres a partir del parámetro de la función
  switch(permitidos) {
    case 'num':
      permitidos = numeros;
      break;
    case 'car':
      permitidos = caracteres;
      break;
    case 'num_car':
      permitidos = numeros_caracteres;
      break;
  }
  var evento = elEvento || window.event;
  var codigoCaracter = evento.charCode || evento.keyCode;
  var caracter = String.fromCharCode(codigoCaracter);
  var tecla_especial = false;
  for(var i in teclas_especiales) {
    if(codigoCaracter == teclas_especiales[i]) {
      tecla_especial = true;
      break;
    }
  }
  return permitidos.indexOf(caracter) != -1 || tecla_especial;
}

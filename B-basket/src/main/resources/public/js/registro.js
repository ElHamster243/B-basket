
  document.getElementById('crear').addEventListener('click', guardarCuenta);
  function guardarCuenta(e) {
      var resultElement = document.getElementById('postRegistro');

      var nombres = document.getElementById('nombres_new').value;
      var apellidos = document.getElementById('apellidos_new').value;
      var correo = document.getElementById('email_new').value;
      var usuario = document.getElementById('usuario_new').value;
      var password = document.getElementById('passwd_new').value;
      var password1 = document.getElementById('passwd_new1').value;
      resultElement.innerHTML = '';
      if(password==password1){
          
        axios.post('registrar', {
            nombres: nombres,
            apellidos: apellidos,
            correo: correo,
            usuario: usuario,
            password: password,
            completed: false
        })

        .then(function (response) {

            alert("Veamos si ya tienes acceso a $proyecto.");
            window.location.href = "/acceso";
        })
        .catch(function (error) {
            window.location.href = "/registro";
            resultElement.innerHTML = generateErrorHTMLOutput(error);
        });
      
      }else{
          alert("Las contraseñas no coinciden.");
      }

      e.preventDefault();
    }
    
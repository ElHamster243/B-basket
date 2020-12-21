
  document.getElementById('btnlogin').addEventListener('click', loginB);
  function loginB(e) {
    alert("Procesando solicitud");

      var resultElement = document.getElementById('login_post');
      var usuario = document.getElementById('usuario').value;
      var password = document.getElementById('password').value;
      
      resultElement.innerHTML = '';
      
          
        axios.post('/acceder', {
            usuario: usuario,
            password: password,
            completed: false
        })

        .then(function (response) {
          alert("Procesando respuesta del servidor.(before)");
          window.location.href = usuario+"/"+password+"/bienvenida";
        })
        .catch(function (error) {
            resultElement.innerHTML = generateErrorHTMLOutput(error);
        });
    

      e.preventDefault();
    }
    
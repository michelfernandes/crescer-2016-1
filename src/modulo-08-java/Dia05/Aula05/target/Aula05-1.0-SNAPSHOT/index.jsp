<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
    </head>
    <body>
    <div class="container">
            
    <h1>Aula05 </h1>
    
     <form role="form" action="pessoa" method="GET">
        <div class="form-group">
          <label for="nome">Nome:</label>
          <input name="nome"  class="form-control" id="nome">
        </div>    
         <div class="form-group">
          <label for="idade">Idade: </label>
          <input name="idade" class="form-control" id="idade" type="number">
        </div>    
         <div class="form-group">
            <label for="nome">Sexo:</label>
            <input type="radio" name="gender" value="Masculino" checked> Masculino
            <input type="radio" name="gender" value="Feminino"> Feminino
            <input type="radio" name="gender" value="Outro"> Outro
         </div>
        <button type="submit" class="btn btn-info">Enviar</button>
      </form>
    
    </div>
    
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
    </body>
</html>

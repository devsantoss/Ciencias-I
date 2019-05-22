function crearInputs() {
  crearCoeficientes();
  crearCondicionesIniciales();
}
function mostrar() {
  getCondiciones();
  getCoeficientes();
  convertirEcuacion();
  var x = convertirEcuacion();
  console.log(x);
}
function crearCoeficientes() {
  var n = parseInt(document.getElementById('cantInp').value);
  const divPrimero = document.getElementById('txtCreados');
  const divSegundo = document.getElementById('coef');
  for (var i = 0; i <= n; i++) {
    var input = document.createElement("input");
    input.id = "coeficiente" + i ;
    input.classList.add('txt');
    divPrimero.insertBefore(input, divSegundo);
  }
}
function crearCondicionesIniciales() {
  var n = parseInt(document.getElementById('cantInp').value);
  const divPrimero = document.getElementById('textos');
  const divSegundo = document.getElementById('condiciones');
  for (var i = 0; i < n; i++) {
    for (var j = 0; j < 2; j++) {
      var input = document.createElement("input");
      input.id = "condicion" + i + j;
      input.classList.add('txt');
      divPrimero.insertBefore(input, divSegundo);
    }
    var println = document.createElement("br");
		divPrimero.insertBefore(println, divSegundo);
  }
}
function getCoeficientes() {
  var n = parseInt(document.getElementById('cantInp').value);
  var coefArr = new Array();
  for (var i = 0; i <= n; i++) {
    var input = "coeficiente" + i;
    coefArr[i] = parseInt(document.getElementById(input).value);
  }
  return coefArr;
}
function getCondiciones() {
  var n = parseInt(document.getElementById('cantInp').value);
  var mCoef = new Array();
  for (var i = 0; i < n; i++) {
    mCoef[i] = new Array(2);
  }
  for (var i = 0; i < n; i++) {
    for (var j = 0; j < 2; j++) {
      var input = "condicion" + i + j;
      mCoef[i][j] = parseInt(document.getElementById(input).value);
    }
  }
  return mCoef;
}

var ecuacion = new Array();
function convertirEcuacion() {
  var x = getCoeficientes();
  var exponente = x.length;
  for (var i = 0; i < x.length ; i++) {
    if (i != x.length - 1) {
      exponente -= 1;
      ecuacion[i] = x[i] + "x^" + exponente;
    }else {
      ecuacion[i] = x[i];
    }
  }
  return ecuacion;
}

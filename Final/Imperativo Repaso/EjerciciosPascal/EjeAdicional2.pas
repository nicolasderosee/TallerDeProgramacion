Program EjeAdicional2;
Const
 DimF = 300;
Type
 indice=0..DimF;
 rango= 1..DimF;
 oficina=record
    codID:integer;
    dni:integer;
    valor:real;
 end;
 vector = Array [rango] of oficina;

procedure CrearVector(var v:vector; var dimL:indice);

  Procedure LeerOficina(var o:oficina);
  begin
    write('ingrese el codigo de identificacion del propietario:');
    readln(o.codID);
    if(o.codID<>-1) then begin
       write('ingrese el dni del propietario:');
       readln(o.dni);
       write('ingrese el valor de la expensa:');
       readln(o.valor);
       writeln();
    end;
  end;

  Procedure Agregar (var v: vector; var dimL:indice;
  elem:oficina; var exito : boolean);
  begin
    If (dimL < dimF) then begin
      dimL:= dimL+1;
      v[dimL]:= elem;
      exito:= true;
    end
    else exito:= false;
  end;

var
 elem:oficina; ok:boolean;
begin
 dimL:=0;
 ok:= true;
 LeerOficina(elem);
 while(ok = true) and (elem.codID<>-1) do begin
   Agregar(v,dimL,elem,ok);
   LeerOficina(elem);
 end;
end;


procedure ImprimirVector(v:vector; dimL:indice);
var i:integer;
begin
 for i:= 1 to dimL do begin
   writeln();
   writeln('Oficina:', i);
   writeln('codigo de identificacion del propietario:',v[i].codID);
   writeln('dni del propietario:',v[i].dni);
   writeln('valor de la expensa:',v[i].valor:3:0);
 end;
 writeln();
 writeln('dimension logica:' , dimL);
end;

Procedure OrdenacionPorInsercion(var v:vector; dimL:indice);
var i,j:integer; elem:oficina;
begin
 for i:= 2 to dimL do begin
   elem:=v[i]; //me guardo el elem que esta en la pos i 
   j:=i-1; 
   while(j>0) and (v[j].codID > elem.codID) do begin
     v[j+1]:= v[j];
     j:=j-1;
   end;
   v[j+1]:=elem;
 end;
end;

Procedure busquedaDicotomica(v:vector; ini,fin:indice; dato:integer; var pos:indice);
var
 medio:indice;
begin
  if(ini=fin) and (dato<>v[ini].codID) then
    pos:=0
  else begin
       medio:= (ini+fin) div 2;
       if (dato=v[medio].codID) then
         pos:=medio
       else begin
           if (dato<v[medio].codID) then fin:=medio-1
	       else  ini:=medio+1;
           busquedaDicotomica (v, ini, fin, dato, pos);
       end;
  end;
end;

Var
 v:vector; dimL:indice; codID:integer; ini,pos:indice;
Begin
 ini:=1; pos:=0;
 CrearVector(v,dimL);
 writeln('Pago de las expensas de las oficinas:');
 ImprimirVector(v,dimL);
 OrdenacionPorInsercion(v,dimL);
 writeln();
 writeln('Vector ordenado por codigo de identificacion:');
 ImprimirVector(v,dimL);
 writeln();
 write('ingrese un codigo de identificacion a buscar:');
 readln(codID);
 busquedaDicotomica(v,ini,dimL,codID,pos);
 writeln();
 if(pos=0) then
   writeln('el codigo de id ingresado no existe')
 else
   writeln('dni del propietario con el codigo de id ' ,codID,': ',v[pos].dni);
 Readln;
End.

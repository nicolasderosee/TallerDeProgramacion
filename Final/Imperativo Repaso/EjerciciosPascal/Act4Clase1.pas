program ClaseAct4;
Const 
 DimF= 20;
Type
 indice = 0..Dimf;
 participante=record
   cod:integer;
   edad:integer;
 end;
 vec = Array [1..Dimf] of participante;

Procedure CrearVector(var v:vec; var dimL:indice);

 procedure LeerParticipante(var p:participante);
 begin
  write('ingrese el codigo del participante: ');
  readln(p.cod);
  if(p.cod<>-1)then begin
   write('ingrese la edad del participante: ');
   readln(p.edad);
  end;
 end;

 Procedure Agregar(var v:vec; var dimL:indice; elem:participante; var exito:boolean);
 begin
  If (dimL < dimF) then begin
   dimL:= dimL+1;
   v[dimL]:= elem;
   exito:=true
  end
  else
   exito:=false;
 end;

var p:participante; exito:boolean;
begin
 dimL:=0;
 exito:=true;
 LeerParticipante(p);
 while(exito=true) and (p.cod<>-1)do begin
  Agregar(v,dimL,p,exito);
  LeerParticipante(p);
 end;
end;

Procedure OrdenacionPorInsercion(var v:vec; var dimL:indice);
var i,j:integer; elem:participante;
begin
 for i:= 2 to dimL do begin
   elem:=v[i];
   j:=i-1;
   while(j>0) and (v[j].edad>elem.edad) do begin
     v[j+1]:= v[j];
     j:=j-1;
   end;
 v[j+1]:=elem;
 end;
end;


Procedure EliminarElemento(var v:vec; var dimL:indice);
 Procedure BorrarElemento(var v:vec; var dimL:indice; elem:participante; var exito:boolean);

   Function BuscarPosElem(elem:participante; v:vec; dimL:indice):indice;
   var pos:indice;
   begin
     pos:=1;
     while (pos<=dimL) and (elem.edad<>v[pos].edad) do
       pos:=pos+1;
     if (pos>dimL) then
       pos:=0;
     BuscarPosElem :=pos;
   end;

   Procedure BorrarElemPosModif(var v:vec; var dimL:indice; pos:indice);
   var j:integer;
   begin
     for j:=pos+1 to dimL do
        v [j-1]:=v[j] ;
     dimL := dimL - 1 ;
   end;

 var pos:indice;
 begin
  pos:= BuscarPosElem (elem,v,dimL);
  if (pos <> 0) then begin
    BorrarElemPosModif (v,dimL,pos);
    exito:= true
  end
  else exito:= False;
 end;


 Function DetEdad(var p:participante): boolean;
 begin
  if(p.edad=20) or (p.edad=21) or (p.edad=22) then
   DetEdad:=true
  else
   DetEdad:=False;
 end;


var p:participante; ok:boolean;
begin
 if(DetEdad(p)=true) then begin
   BorrarElemento(v,dimL,p,ok);
   if(ok=true)then
   writeln('se eliminaron los participantes con edades entre 20 y 22');
 end
 else
  writeln('no se elimino ningun participante');
 readln;
end;


Procedure ImprimirVector(v:vec; dimL:indice);
 var i:integer;
begin
 for i:=1 to dimL do
  writeln('codigo:',v[i].cod, '  ' , 'edad:',v[i].edad);
end;


var
 v:vec; dimL:indice;
begin
 CrearVector(v,dimL);
 ImprimirVector(v,dimL);
 write('se imprimio el vector');
 writeln();
 OrdenacionPorInsercion(v,dimL);
 ImprimirVector(v,dimL);
 write('se imprimio el vector ordenado');
 writeln();
 EliminarElemento(v,dimL);
 ImprimirVector(v,dimL);
 writeln('se imprimio el vector modificado');
 readln;
end.

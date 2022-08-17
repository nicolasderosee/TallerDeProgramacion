program PalabraPolindromo;
Type
cadena5 = string[5];
lista=^nodo;
nodo=record
 datos:string;
 sig:lista;
end;


procedure CrearListaAgregarAtras(var L:lista);

   procedure AgregarAtras (var pri, ult: lista; elem: cadena5);
   var nue : lista;
   begin
     new (nue);
     nue^.datos:= elem;
     nue^.sig := NIL;
     if pri <> Nil then
        ult^.sig := nue
     else
        pri := nue;
     ult := nue;
   end;
var
 elem:cadena5; ult:lista;
begin
 L:=NIL; ult:=NIL;
 writeln('ingrese la palabra de a una letra:');
 readln(elem);
 while(elem<>'zzz') do begin
   AgregarAtras(L,ult,elem);
   readln(elem);
 end;
end;


procedure ImprimirLista(L:lista);
begin
 while(L<>NIL) do begin
  writeln(L^.datos);
  L:=L^.sig;
 end;
end;

Procedure esPalindromo(L1: lista; var L2: lista; var exito: boolean);
begin
 if (L1<>NIL) then begin
     esPalindromo(L1^.sig,L2,exito);
     if(L1^.datos = L2^.datos) and (exito<>false) then  begin
       exito:=true;
       L2:= L2^.sig
     end
     else
        exito:= false;
 end;
end;

var L:lista; ok:boolean;
Begin
 CrearlistaAgregarAtras(L);
 writeln();
 ImprimirLista(L);
 writeln('se imprimio la lista');
 ok:=true;
 esPalindromo(L, L, ok);
 writeln();
 if(ok=true) then
   writeln('la palabra es palindromo')
 else writeln('la palabra no es palindromo');
 Readln;
End.

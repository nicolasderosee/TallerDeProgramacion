Program x;
type 
   viaje = record 
      cod: integer;
      cuil: integer;
      cantD: integer;
   end;
   
   viaje2 = record
      cuil:integer;
      totalD: integer;
   end;

   lista = ^nodo;
   nodo = record 
       dato: viaje;
       sig: lista; 
   end;

   arbol = ^nodoA;
   nodoA = record 
        dato:viaje2;
        HI: arbol;
        HD: arbol;
   end;

Procedure cargarViajes(var l:lista); //se dispone
begin
end;
 

procedure crearArbol(var a:arbol; cuil,dias:integer);
begin
  if(a=nil) then begin
      new(a);
      a^.dato.cuil:= cuil;
      a^.dato.totalD:= dias;
      a^.HI:=nil;
      a^.HD:=nil;
  end
  else 
    if (cuil = a^.dato.cuil) then
         a^.dato.totalD := a^.dato.totalD + dias
    else 
           if(cuil < a^.dato.cuil) then    
                          crearArbol(a^.HI,cuil,dias)     
            else crearArbol(a^.HD,cuil,dias)
end;


procedure recorrer(L:lista; var a:arbol);
begin
   if (L<>NIL) then begin
     crearArbol(a,L^.dato.cuil,L^.dato.cantD);
     recorrer(L^.sig,a)
   end;
end;


Procedure maximo (a: arbol; var max:integer; var cuil:integer); 
begin
   if ( a<> nil ) then begin
     maximo(a^.HI,max,cuil);
     if (a^.dato.totalD > max) then begin
        max:= a^.dato.totalD;
        cuil:= a^.dato.cuil;
     end;
     maximo(a^.HD,max,cuil);
   end;
end;

Var
  l:lista; a:arbol; max:integer; cuil:integer;
      
Begin  
   max:= -1;
   a:=nil;
   cargarViajes(l); //se dispone 
   recorrer(l,a);
   maximo(a,max,cuil);
End.

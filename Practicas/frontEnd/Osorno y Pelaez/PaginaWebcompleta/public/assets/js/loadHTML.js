export class loadHTML{
    contructor(contenidoHTML){
        this.contenidoHTML = contenidoHTML; 
    }
    async cargarContenido(){
        if(this.contenidoHTML){
            return;
        }
        try{
            // Necesitamos ir a la ubicación del archivo
            const respuesta = await fetch("../../../src/view/templates/contenidoHTML.php");
            if(!respuesta.ok){
                throw new error("No se ha localizado el archivo");
            }
            // Convertimos el contenido en texto
            const contenidoHTML = await respuesta.text();
            
        }catch(error){
            console.log("ERROR: ")
        }
    }
}
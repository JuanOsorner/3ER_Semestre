export class loadHTML{
    contructor(contenidoHTML){
        this.contenidoHTML = contenidoHTML;
        // Vamos a usar new Map() para almacenar objetos DOM
        this.templates = new Map(); // Usamos map para almacenar las plantillas: ejemplo div, etc...
        this.cargado = false;
    }
    // Cargamos el contenido HTML
    async cargarContenido(){
        if(this.contenidoHTML){
            // Si devuelve null cierra la función
            return;
        }
        try{
            // Necesitamos ir a la ubicación del archivo
            const respuesta = await fetch("../../../src/view/templates/contenidoHTML.php");
            if(!respuesta.ok){
                throw new Error("No se ha localizado el archivo");
            }
            // Convertimos el contenido en texto
            const contenidoHTML = await respuesta.text();
            // Esto es para parsear el texto a un objeto DOM
            const parser = new DOMParser();
            const frag = parser.parseFromString(contenidoHTML, 'text/html'); // text/html es para decir que es texto html
            // Ahora podemos manipularlo dentro de esta función
            frag.querySelectorAll('template').forEach(template => {
                // Guardamos dentro del mapa: guardamos por id cada template. Eso dice este fragmento
                this.templates.set(template.id, template);
            });
            this.cargado = true;
            console.log("plantillas cargadas exitosamente");
        }catch(error){
            console.log("ERROR: ",error);
        }
    }
    get(id){
        if(!this.cargado){
            //Este condicional solo es por si tenemos un error en el main
            console.log("Error, primero debemos cargar el async");
            return null;
        }
        // Aqui vamos a cargar las plantillas para que podamos manipularlas desde el main
        const template = this.templates.get(id);
        // Si todo va bien retornamos el una copia del contenido que estamos buscando
        return template ? template.content.cloneNode(true) : null;
    }
}
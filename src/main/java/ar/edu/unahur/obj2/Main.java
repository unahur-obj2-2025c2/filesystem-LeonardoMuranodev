package ar.edu.unahur.obj2;

public class Main {
    public static void main(String[] args) {
        FileSystem sistemaArchivo = FileSystem.getInstance();

        // Archivos sueltos en el root
        sistemaArchivo.agregarElemento(new Archivo("Notas", "txt", 10));
        sistemaArchivo.agregarElemento(new Archivo("Dibujo-A", "jpg", 290));

        // Carpeta A
        Carpeta carpetaA = new Carpeta("Carpeta A");
        sistemaArchivo.agregarElemento(carpetaA);
        carpetaA.agregarElemento(new Archivo("Imagen-A", "jpg", 140));
        carpetaA.agregarElemento(new Archivo("Rock", "mp3", 500));

        // Carpeta B dentro de A
        Carpeta carpetaB = new Carpeta("Carpeta B");
        carpetaA.agregarElemento(carpetaB);
        carpetaB.agregarElemento(new Archivo("Foto-B", "png", 80));

        // Carpeta C dentro de B
        Carpeta carpetaC = new Carpeta("Carpeta C");
        carpetaB.agregarElemento(carpetaC);
        carpetaC.agregarElemento(new Archivo("Documento-C", "pdf", 300));

        // Carpeta D dentro de C
        Carpeta carpetaD = new Carpeta("Carpeta D");
        carpetaC.agregarElemento(carpetaD);
        carpetaD.agregarElemento(new Archivo("Video-D", "mp4", 1200));

        // Mostrar con indentación elegida (ej: 2 espacios por nivel)
        sistemaArchivo.mostrar(2);
    }
}


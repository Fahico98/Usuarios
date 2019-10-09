
import java.util.Date;

public class Usuario {
   
   Encriptador encriptador = new Encriptador();
   
   private String nombre;
   private long documentoId;
   private Date fechaNac;
   private int edad;
   private String clave;
   
   public Usuario(String nombre, long documentoId, Date fechaNac){
      this.nombre = nombre;
      this.documentoId = documentoId;
      this.fechaNac = fechaNac;
      this.calcularEdad();
   }
   
   private void calcularEdad(){
      Date fechaActual = new Date();
      long edadSegundos = fechaActual.getTime() - this.getFechaNac().getTime();
      double edadAnhos = edadSegundos / 3.15576e+10;
      this.edad = (int) Math.floor(edadAnhos);
   }
   
   public String getNombre() {
      return nombre;
   }
   
   public void setNombre(String nombre) {
      this.nombre = nombre;
   }
   
   public long getDocumentoId() {
      return documentoId;
   }
   
   public void setDocumentoId(long documentoId) {
      this.documentoId = documentoId;
   }
   
   public Date getFechaNac() {
      return fechaNac;
   }
   
   public void setFechaNac(Date fechaNac) {
      this.fechaNac = fechaNac;
   }
   
   public String getClave() {
      return clave;
   }
   
   public void setClave(String clave) {
      this.clave = clave;
   }
   
   public int getEdad() {
      return edad;
   }
}

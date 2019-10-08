
public class Encriptador {
   
   public byte[] encriptar(byte[] data){
      byte[] enc = new byte[data.length];
      for (int i = 0; i < enc.length; i++) {
         enc[i] = (i % 2 == 0) ? (byte)(data[i] + 1) : (byte)(data[i] - 1);
      }
      return enc;
   }
   
   public byte[] desencriptar(byte[] data){
      byte[] des = new byte[data.length];
      for (int i = 0; i < des.length; i++) {
         des[i] = (i % 2 == 0) ? (byte)(data[i] - 1) : (byte)(data[i] + 1);
      }
      return des;
   }
}

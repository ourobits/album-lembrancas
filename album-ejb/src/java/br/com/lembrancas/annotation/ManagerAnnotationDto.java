/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lembrancas.annotation;

import br.com.lembrancas.dto.CategoriasDto;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jacob_lisboa
 */
public class ManagerAnnotationDto implements Serializable {

    
    private Logger LOG = Logger.getLogger(ManagerAnnotationDto.class.getName());
    private int index = 0;

 

    public void analizarCamposObrigatorios(Object dto) throws CampoObrigatorioException{
        Campo campo = null;
        Field[] fields = dto.getClass().getDeclaredFields();
        CampoObrigatorioException campoObrigatorioException = new CampoObrigatorioException();
        List<MensagensErro> campos = new ArrayList<MensagensErro>();
        
        for (Field field : fields) {
            if (field.isAnnotationPresent(Campo.class)) {
                field.setAccessible(true);
                try {
                    campo = field.getAnnotation(Campo.class);

                    Object value = field.get(dto);
                    if(campo.obrigatorio()&&(value==null || "".equals(value.toString().trim()))){
                        campos.add(new MensagensErro(campo.mensagem()));
                    }
                    
                } catch (Throwable ex) {
                    System.out.printf("Test %s failed: %s %n", field, ex.getCause());
                }
            }
        }
        
        if(campos.size()>0){
            campoObrigatorioException.setCamposObrig(campos);
            throw campoObrigatorioException;
        }
       

    }
    
    // <editor-fold defaultstate="collapsed" desc="comment">
//    public static void main(String args[]) {
//            ManagerAnnotationDto managerAnnotationDto = new ManagerAnnotationDto();
//            CategoriasDto categoriasDto = new CategoriasDto();
//            categoriasDto.setTitulo("rer");
//            categoriasDto.setDescricao("ss");
//        try {
//            managerAnnotationDto.analizarCamposObrigatorios(categoriasDto);
//        } catch (CampoObrigatorioException ex) {
//            Logger.getLogger(ManagerAnnotationDto.class.getName()).log(Level.SEVERE, null, ex);
//            List<MensagensErro> c = ex.getCamposObrig();
//            for (MensagensErro campo : c) {
//                System.out.println(campo.getMensagem());
//            }
//            
//        }
//    }
    // </editor-fold>
}

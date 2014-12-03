package br.com.peneira.bean.upload;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
 
import org.primefaces.model.UploadedFile;
 
@ManagedBean
@SessionScoped
public class Upload {
	UploadedFile file;
	 
    public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }
 
    public String dummyAction(){
        System.out.println("Uploaded File Name Is :: "+file.getFileName()+" :: Uploaded File Size :: "+file.getSize());
        return "";
	
	

	
}

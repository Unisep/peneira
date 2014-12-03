package com.peneira.bean.upload;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="u")
@ViewScoped
public class Upload {

//	public void upload() throws IOException {
//		byte[] bytes;
//		try {
//			File file = new File(image.getSubmittedFileName());
//			String result = "";
//			String ext = getExtencaoImg(image.getSubmittedFileName());
//			try (InputStream input = image.getInputStream()) {
//
//				final BufferedImage bufferedImage = ImageIO.read(input);
//
//				ByteArrayOutputStream byteArrayOS = new ByteArrayOutputStream();
//				OutputStream outputStream64 = new Base64OutputStream(
//						byteArrayOS);
//				ImageIO.write(bufferedImage, ext, outputStream64);
//
//				result = "data:image/" + ext + ";base64, "
//						+ byteArrayOS.toString("UTF-8");
//				setUrlImageLogo(result);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

//	public String getExtencaoImg(String nomeImg) {
//		String ext[] = nomeImg.split("\\.");
//		int i = ext.length;
//		if (i > 1) {
//			return ext[i - 1];
//		}
//		return null;
//	}
//
//	public void validarImagem(FacesContext facesContext, UIComponent component,
//			Object value) throws MessagingException {
//
//		Part file = (Part) value;
//		if (("image/jpg".equals(file.getContentType()))
//				|| ("image/png".equals(file.getContentType()))
//				|| ("image/jpeg".equals(file.getContentType()))) {
//			return;
//		} else {
//			final FacesMessage message = new FacesMessage(
//					FacesMessage.SEVERITY_ERROR, "Formato indisponivel",
//					"Imagem indisponivel");
//			throw new ValidatorException(message);
//		}
//	}
}

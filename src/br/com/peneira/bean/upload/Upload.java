package br.com.peneira.bean.upload;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.imageio.ImageIO;
import javax.servlet.http.Part;

import org.apache.commons.codec.binary.Base64OutputStream;
import org.apache.commons.io.output.ByteArrayOutputStream;

<<<<<<< HEAD
import br.edu.unisep.hibernate.GenericDAO;

import com.peneira.vo.VideoVO;

@ManagedBean(name = "NewUploadBean")
@ViewScoped
public class Upload {
	private Part image;

	public void upload() {
		byte[] bytes;
		try {
			File file = new File(image.getSubmittedFileName());
			String result = "";

			try (InputStream input = image.getInputStream()) {

				final BufferedImage bufferedImage = ImageIO.read(input);

				ByteArrayOutputStream byteArrayOS = new ByteArrayOutputStream();
				OutputStream outputStream64 = new Base64OutputStream(
						byteArrayOS);
				ImageIO.write(bufferedImage, "mpg", outputStream64);

				result = "data:image/" + "mpg" + ";base64, "
						+ byteArrayOS.toString("UTF-8");
				setUrlImageLogo(result);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void setUrlImageLogo(String result) {
		

	}

	private VideoVO video = new VideoVO();

	public String save() {

		GenericDAO<VideoVO> dao = new GenericDAO<VideoVO>();
		if (video.getId() != null && video.getId() != 0) {
			dao.update(video);
		} else {
			dao.save(video);
		}
		return "new_video";
	}

	public VideoVO getVideos() {
		return video;
	}

	public void setVideos(VideoVO video) {
		this.video = video;
	}

	public Part getImage() {
		return image;
	}

	public void setImage(Part image) {
		this.image = image;
	}

=======
@ManagedBean(name = "NewUploadBean")
@ViewScoped
public class Upload {
//	private VideoVO video = new VideoVO();
//
//	public String save() {
//
//		GenericDAO<VideoVO> dao = new GenericDAO<VideoVO>();
//		if (video.getId() != null && video.getId() != 0) {
//			dao.update(video);
//		} else {
//			dao.save(video);
//		}
//		return "new_video";
//	}
//
//	public VideoVO getVideos() {
//		return video;
//	}
//
//	public void setVideos(VideoVO video) {
//		this.video = video;
//	}
>>>>>>> 7a4bae7eadb89a4c44981cecbffc71104bbda363
}

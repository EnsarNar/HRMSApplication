package kodlamaio.hmrs.core.Cloudinary;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hmrs.core.utilities.results.DataResult;

public interface CloudinaryService {

	DataResult<?> save(MultipartFile file);
}

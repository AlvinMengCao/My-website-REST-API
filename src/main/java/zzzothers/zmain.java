package zzzothers;


import com.cloudinary.Api;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import dao.GalleryDAO;
import pojo.GalleryPOJO;

import java.util.Date;
import java.util.Map;

/**
 * Created by alvin on 6/2/16.
 */
public class zmain {
    private static final Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "hjei7ekfi",
            "api_key", "941183678927842",
            "api_secret", "359QMZPBNnT4w-h6umV_ffLIP6U"));
    private static final Api api = cloudinary.api();
    public static void main(String[] args) throws Exception{
        GalleryPOJO g = new GalleryPOJO.Builder("example", new Date())
                .description("example").num(1).url1("example").build();
        System.out.println("nihao");
    }

}

package logic;

import com.cloudinary.Api;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import java.util.*;

/**
 * Created by alvin on 6/5/16.
 */
public class PhotoLogic {
    private static final PhotoLogic pl = new PhotoLogic();
    private static final Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "hjei7ekfi",
            "api_key", "941183678927842",
            "api_secret", "359QMZPBNnT4w-h6umV_ffLIP6U"));
    private static final Api api = cloudinary.api();
    private PhotoLogic(){}

    /**
     * Grab all photo urls in file system
     * @return List of urls
     * @throws Exception Who knows what kind of exception,
     * CloudinaryUtils does't provide document. Resource code
     * just throw Exception, no more details.
     */
    public List<String> getAll() throws Exception{
        Map result = api.resources(ObjectUtils.emptyMap());
        return grabUrl(result);
    }

    /**
     * Grab all photos under a certain folder. If under /Yelloestone,
     * pass in "YellowStone", or "YellowStone/FirstDay"
     * @param path
     * @return
     * @throws Exception
     */
    public List<String> getByTag(String tag) throws Exception{
        Map result =  api.resourcesByTag(tag, ObjectUtils.emptyMap());
        return grabUrl(result);
    }

    /**
     * Grab all photos under a certain folder. If under /Yelloestone,
     * pass in "YellowStone", or "YellowStone/FirstDay"
     * @param path
     * @return
     * @throws Exception
     */
    public List<String> getByPath(String path) throws Exception{
        Map result =  api.resources(ObjectUtils.asMap("type", "upload", "prefix", path));
        return grabUrl(result);
    }

    /**
     * Passed in parameter is a Map<String, List<Map<String, String>>> object
     * Took me a lot of time to figure it out. Bullshit object and document.
     * @param map
     * @return
     */
    @SuppressWarnings("unchecked")
    private List<String> grabUrl(Map map){
        List<String> result = new ArrayList<String>();
        List<Map> list = (List)map.get("resources");
        for (Map<String, String> m : list){
            String secure_url = m.get("secure_url");
            result.add(secure_url);
            m = null;
        }
        map = null;
        return result;
    }
    public static PhotoLogic getInstance(){
        return pl;
    }
}

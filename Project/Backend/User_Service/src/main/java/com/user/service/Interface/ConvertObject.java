package com.user.service.Interface;import com.user.entity.User;
import com.user.vo.UserVO;

public interface ConvertObject {
	User convertFromVotoEntity(UserVO user);
}

package cn.tuyucheng.taketoday.pattern.cleanarchitecture.usercreation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class UserUnitTest {

   UserRegisterDsGateway userDsGateway = mock(UserRegisterDsGateway.class);
   UserPresenter userPresenter = mock(UserPresenter.class);
   UserFactory userFactory = mock(UserFactory.class);
   UserInputBoundary interactor = new UserRegisterInteractor(userDsGateway, userPresenter, userFactory);

   @Test
   void given123Password_whenPasswordIsNotValid_thenIsFalse() {
      User user = new CommonUser("Tuyucheng", "123");

      assertThat(user.passwordIsValid()).isFalse();
   }

   @Test
   void givenTuyuchengUserAnd123456Password_whenCreate_thenSaveItAndPrepareSuccessView() {
      User user = new CommonUser("tuyucheng", "123456");
      UserRequestModel userRequestModel = new UserRequestModel(user.getName(), user.getPassword());
      when(userFactory.create(anyString(), anyString())).thenReturn(new CommonUser(user.getName(), user.getPassword()));

      interactor.create(userRequestModel);

      verify(userDsGateway, times(1)).save(any(UserDsRequestModel.class));
      verify(userPresenter, times(1)).prepareSuccessView(any(UserResponseModel.class));
   }
}
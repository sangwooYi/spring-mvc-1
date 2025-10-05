package hello.servlet.web.frontcontroller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MyView {

    String viewPath;

    public MyView(String viewPath) {
        this.viewPath = viewPath;
    }

    // 공통 렌더링 함수
    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher(this.viewPath);
        dispatcher.forward(request, response);
    }
}

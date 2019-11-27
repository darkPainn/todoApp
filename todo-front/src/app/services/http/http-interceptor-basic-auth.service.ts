import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HttpInterceptorBasicAuthService implements HttpInterceptor{
  intercept(request: HttpRequest<any>, next: HttpHandler) {
    let httpBasicAuthHeader = 'Basic ' + window.btoa('user:pass');
    request = request.clone({
      setHeaders:{ Authorization:httpBasicAuthHeader}
    });
    return next.handle(request);
  }

  constructor() { }
}

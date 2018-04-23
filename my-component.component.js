System.register(['angular2/core', './test.component'], function(exports_1, context_1) {
    "use strict";
    var __moduleName = context_1 && context_1.id;
    var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
        var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
        if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
        else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
        return c > 3 && r && Object.defineProperty(target, key, r), r;
    };
    var __metadata = (this && this.__metadata) || function (k, v) {
        if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
    };
    var core_1, test_component_1;
    var MyComponentComponent;
    return {
        setters:[
            function (core_1_1) {
                core_1 = core_1_1;
            },
            function (test_component_1_1) {
                test_component_1 = test_component_1_1;
            }],
        execute: function() {
            MyComponentComponent = (function () {
                function MyComponentComponent() {
                }
                MyComponentComponent.prototype.ngOnInit = function () {
                    this.name = "Sowmya";
                };
                MyComponentComponent = __decorate([
                    core_1.Component({
                        selector: 'my-component',
                        template: "\n\tHi, I'm <span [class.is-awesome]=\"inputElement.value==='yes'\">{{name}}</span> and this is my very first angular2 component! <span [class.is-awesome]=\"inputElement.value==='yes'\">It's so Awesome!</span>\n\t\t<br>\n\t\t<br>\n\t\tIs it Awesome?\n\t\t<input type=\"text\" #inputElement (keyup)=\"0\">\n\t\t<br><br>\n\t\t<button [disabled]=\"inputElement.value !='yes'\">Only enabled if 'yes' was entered</button>\n\n\t\t<Test></Test>\n\t",
                        directives: [test_component_1.TestComponent],
                        styleUrls: ['src/css/mycomponent.css']
                    }), 
                    __metadata('design:paramtypes', [])
                ], MyComponentComponent);
                return MyComponentComponent;
            }());
            exports_1("MyComponentComponent", MyComponentComponent);
        }
    }
});

//# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIm15LWNvbXBvbmVudC5jb21wb25lbnQudHMiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6Ijs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7WUFvQkE7Z0JBQUE7Z0JBT0EsQ0FBQztnQkFKRCx1Q0FBUSxHQUFSO29CQUNBLElBQUksQ0FBQyxJQUFJLEdBQUMsUUFBUSxDQUFDO2dCQUNuQixDQUFDO2dCQXJCRDtvQkFBQyxnQkFBUyxDQUFDO3dCQUNWLFFBQVEsRUFBQyxjQUFjO3dCQUN2QixRQUFRLEVBQUMsMmJBVVI7d0JBQ0QsVUFBVSxFQUFDLENBQUMsOEJBQWEsQ0FBQzt3QkFDMUIsU0FBUyxFQUFFLENBQUMseUJBQXlCLENBQUM7cUJBQ3RDLENBQUM7O3dDQUFBO2dCQVFGLDJCQUFDO1lBQUQsQ0FQQSxBQU9DLElBQUE7WUFQRCx1REFPQyxDQUFBIiwiZmlsZSI6Im15LWNvbXBvbmVudC5jb21wb25lbnQuanMiLCJzb3VyY2VzQ29udGVudCI6WyJpbXBvcnQge0NvbXBvbmVudH0gZnJvbSAnYW5ndWxhcjIvY29yZSc7XHJcbmltcG9ydCB7VGVzdENvbXBvbmVudH0gZnJvbSAnLi90ZXN0LmNvbXBvbmVudCc7XHJcbmltcG9ydCB7T25Jbml0fSBmcm9tICdhbmd1bGFyMi9jb3JlJztcclxuXHJcbkBDb21wb25lbnQoe1xyXG5cdHNlbGVjdG9yOidteS1jb21wb25lbnQnLFxyXG5cdHRlbXBsYXRlOmBcclxuXHRIaSwgSSdtIDxzcGFuIFtjbGFzcy5pcy1hd2Vzb21lXT1cImlucHV0RWxlbWVudC52YWx1ZT09PSd5ZXMnXCI+e3tuYW1lfX08L3NwYW4+IGFuZCB0aGlzIGlzIG15IHZlcnkgZmlyc3QgYW5ndWxhcjIgY29tcG9uZW50ISA8c3BhbiBbY2xhc3MuaXMtYXdlc29tZV09XCJpbnB1dEVsZW1lbnQudmFsdWU9PT0neWVzJ1wiPkl0J3Mgc28gQXdlc29tZSE8L3NwYW4+XHJcblx0XHQ8YnI+XHJcblx0XHQ8YnI+XHJcblx0XHRJcyBpdCBBd2Vzb21lP1xyXG5cdFx0PGlucHV0IHR5cGU9XCJ0ZXh0XCIgI2lucHV0RWxlbWVudCAoa2V5dXApPVwiMFwiPlxyXG5cdFx0PGJyPjxicj5cclxuXHRcdDxidXR0b24gW2Rpc2FibGVkXT1cImlucHV0RWxlbWVudC52YWx1ZSAhPSd5ZXMnXCI+T25seSBlbmFibGVkIGlmICd5ZXMnIHdhcyBlbnRlcmVkPC9idXR0b24+XHJcblxyXG5cdFx0PFRlc3Q+PC9UZXN0PlxyXG5cdGBcclxuXHRkaXJlY3RpdmVzOltUZXN0Q29tcG9uZW50XVxyXG5cdHN0eWxlVXJsczogWydzcmMvY3NzL215Y29tcG9uZW50LmNzcyddXHJcbn0pXHJcbmV4cG9ydCBjbGFzcyBNeUNvbXBvbmVudENvbXBvbmVudCBpbXBsZW1lbnRzIE9uSW5pdCB7XHJcbm5hbWU6IHN0cmluZztcclxuXHJcbm5nT25Jbml0KCk6YW55IHtcclxudGhpcy5uYW1lPVwiU293bXlhXCI7XHJcbn1cclxuXHRcclxufSJdLCJzb3VyY2VSb290IjoiL3NvdXJjZS8ifQ==

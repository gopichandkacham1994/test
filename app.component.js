System.register(['angular2/core'], function(exports_1, context_1) {
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
    var core_1;
    var AppComponent;
    return {
        setters:[
            function (core_1_1) {
                core_1 = core_1_1;
            }],
        execute: function() {
            AppComponent = (function () {
                function AppComponent() {
                }
                AppComponent.prototype.ngOnInit = function () {
                    this.switch1Number = Math.round(Math.random());
                    this.switch2Number = Math.round(Math.random());
                    this.switch3Number = Math.round(Math.random());
                    this.switch4Number = Math.round(Math.random());
                    console.log(this.switch1Number, this.switch2Number);
                    this.switch3Number, this.switch4Number;
                };
                AppComponent = __decorate([
                    core_1.Component({
                        selector: 'my-app',
                        template: "\n<section class=\"setup\">\n\t<h1>Game Setup</h1>\n\tEnter your name please:\n\t<input type=\"text\" #name (keyup)=\"0\">\n</section> \n\n<section\n\t[ngClass]= \"{\n\tpuzzle : true,\n\tsolved: switch1.value == switch1Number && switch2.value == switch2Number && switch3.value == switch3Number && switch4.value == switch4Number \n\t}\"\n\n \t[ngStyle]=\"{display: name.value === '' ? 'none' : 'block'}\">\n \t\n \t<h2>The Puzzle |\n \t{{switch1.value == switch1Number && switch2.value == switch2Number && switch3.value == switch3Number && switch4.value == switch4Number ? 'SOLVED' : 'NOT SOLVED'}}\n \t</h2>\n\n\t<h2>The Puzzle</h2>\n\t<p> Ok,Welcome <span class=\"name\">{{name.value}}</span></p>\n\t<br>\n\tSwitch 1:\n\t<input type=\"text\" #switch1 (keyup)=\"0\"><br>\n\tSwitch 2:\n\t<input type=\"text\" #switch2 (keyup)=\"0\"><br>\n\tSwitch 3:\n\t<input type=\"text\" #switch3 (keyup)=\"0\"><br>\n\tSwitch 4:\n\t<input type=\"text\" #switch4 (keyup)=\"0\"><br>\n</section>\n<h2 [hidden]=\"switch1.value != switch1Number || switch2.value != switch2Number || switch3.value != switch3Number || switch4.value != switch4Number\">Congratulations {{name.value}},you did it!</h2>   \n"
                    }), 
                    __metadata('design:paramtypes', [])
                ], AppComponent);
                return AppComponent;
            }());
            exports_1("AppComponent", AppComponent);
        }
    }
});

//# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbImFwcC5jb21wb25lbnQudHMiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6Ijs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7WUF1Q0E7Z0JBQUE7Z0JBYUEsQ0FBQztnQkFQRCwrQkFBUSxHQUFSO29CQUNDLElBQUksQ0FBQyxhQUFhLEdBQUUsSUFBSSxDQUFDLEtBQUssQ0FBQyxJQUFJLENBQUMsTUFBTSxFQUFFLENBQUMsQ0FBQztvQkFDOUMsSUFBSSxDQUFDLGFBQWEsR0FBRyxJQUFJLENBQUMsS0FBSyxDQUFDLElBQUksQ0FBQyxNQUFNLEVBQUUsQ0FBQyxDQUFDO29CQUMvQyxJQUFJLENBQUMsYUFBYSxHQUFHLElBQUksQ0FBQyxLQUFLLENBQUMsSUFBSSxDQUFDLE1BQU0sRUFBRSxDQUFDLENBQUM7b0JBQy9DLElBQUksQ0FBQyxhQUFhLEdBQUcsSUFBSSxDQUFDLEtBQUssQ0FBQyxJQUFJLENBQUMsTUFBTSxFQUFFLENBQUMsQ0FBQztvQkFDL0MsT0FBTyxDQUFDLEdBQUcsQ0FBQyxJQUFJLENBQUMsYUFBYSxFQUFFLElBQUksQ0FBQyxhQUFhLENBQUcsQ0FBQTtvQkFBQSxJQUFJLENBQUMsYUFBYSxFQUFFLElBQUksQ0FBQyxhQUFhLENBQUE7Z0JBQzNGLENBQUM7Z0JBaERGO29CQUFDLGdCQUFTLENBQUM7d0JBQ1AsUUFBUSxFQUFFLFFBQVE7d0JBQ2xCLFFBQVEsRUFBRSwrcENBZ0NiO3FCQUNBLENBQUM7O2dDQUFBO2dCQWNGLG1CQUFDO1lBQUQsQ0FiQSxBQWFDLElBQUE7WUFiRCx1Q0FhQyxDQUFBIiwiZmlsZSI6ImFwcC5jb21wb25lbnQuanMiLCJzb3VyY2VzQ29udGVudCI6WyJpbXBvcnQge0NvbXBvbmVudH0gZnJvbSAnYW5ndWxhcjIvY29yZSc7XG5pbXBvcnQge09uSW5pdH0gZnJvbSAnYW5ndWxhcjIvY29yZSc7XG5cbkBDb21wb25lbnQoe1xuICAgIHNlbGVjdG9yOiAnbXktYXBwJyxcbiAgICB0ZW1wbGF0ZTogYFxuPHNlY3Rpb24gY2xhc3M9XCJzZXR1cFwiPlxuXHQ8aDE+R2FtZSBTZXR1cDwvaDE+XG5cdEVudGVyIHlvdXIgbmFtZSBwbGVhc2U6XG5cdDxpbnB1dCB0eXBlPVwidGV4dFwiICNuYW1lIChrZXl1cCk9XCIwXCI+XG48L3NlY3Rpb24+IFxuXG48c2VjdGlvblxuXHRbbmdDbGFzc109IFwie1xuXHRwdXp6bGUgOiB0cnVlLFxuXHRzb2x2ZWQ6IHN3aXRjaDEudmFsdWUgPT0gc3dpdGNoMU51bWJlciAmJiBzd2l0Y2gyLnZhbHVlID09IHN3aXRjaDJOdW1iZXIgJiYgc3dpdGNoMy52YWx1ZSA9PSBzd2l0Y2gzTnVtYmVyICYmIHN3aXRjaDQudmFsdWUgPT0gc3dpdGNoNE51bWJlciBcblx0fVwiXG5cbiBcdFtuZ1N0eWxlXT1cIntkaXNwbGF5OiBuYW1lLnZhbHVlID09PSAnJyA/ICdub25lJyA6ICdibG9jayd9XCI+XG4gXHRcbiBcdDxoMj5UaGUgUHV6emxlIHxcbiBcdHt7c3dpdGNoMS52YWx1ZSA9PSBzd2l0Y2gxTnVtYmVyICYmIHN3aXRjaDIudmFsdWUgPT0gc3dpdGNoMk51bWJlciAmJiBzd2l0Y2gzLnZhbHVlID09IHN3aXRjaDNOdW1iZXIgJiYgc3dpdGNoNC52YWx1ZSA9PSBzd2l0Y2g0TnVtYmVyID8gJ1NPTFZFRCcgOiAnTk9UIFNPTFZFRCd9fVxuIFx0PC9oMj5cblxuXHQ8aDI+VGhlIFB1enpsZTwvaDI+XG5cdDxwPiBPayxXZWxjb21lIDxzcGFuIGNsYXNzPVwibmFtZVwiPnt7bmFtZS52YWx1ZX19PC9zcGFuPjwvcD5cblx0PGJyPlxuXHRTd2l0Y2ggMTpcblx0PGlucHV0IHR5cGU9XCJ0ZXh0XCIgI3N3aXRjaDEgKGtleXVwKT1cIjBcIj48YnI+XG5cdFN3aXRjaCAyOlxuXHQ8aW5wdXQgdHlwZT1cInRleHRcIiAjc3dpdGNoMiAoa2V5dXApPVwiMFwiPjxicj5cblx0U3dpdGNoIDM6XG5cdDxpbnB1dCB0eXBlPVwidGV4dFwiICNzd2l0Y2gzIChrZXl1cCk9XCIwXCI+PGJyPlxuXHRTd2l0Y2ggNDpcblx0PGlucHV0IHR5cGU9XCJ0ZXh0XCIgI3N3aXRjaDQgKGtleXVwKT1cIjBcIj48YnI+XG48L3NlY3Rpb24+XG48aDIgW2hpZGRlbl09XCJzd2l0Y2gxLnZhbHVlICE9IHN3aXRjaDFOdW1iZXIgfHwgc3dpdGNoMi52YWx1ZSAhPSBzd2l0Y2gyTnVtYmVyIHx8IHN3aXRjaDMudmFsdWUgIT0gc3dpdGNoM051bWJlciB8fCBzd2l0Y2g0LnZhbHVlICE9IHN3aXRjaDROdW1iZXJcIj5Db25ncmF0dWxhdGlvbnMge3tuYW1lLnZhbHVlfX0seW91IGRpZCBpdCE8L2gyPiAgIFxuYFxufSlcbmV4cG9ydCBjbGFzcyBBcHBDb21wb25lbnQgaW1wbGVtZW50cyBPbkluaXQge1xuXHRzd2l0Y2gxTnVtYmVyOiBudW1iZXI7XG5cdHN3aXRjaDJOdW1iZXI6IG51bWJlcjtcblx0c3dpdGNoM051bWJlcjogbnVtYmVyO1xuXHRzd2l0Y2g0TnVtYmVyOiBudW1iZXI7XG5cbm5nT25Jbml0KCl7XG5cdHRoaXMuc3dpdGNoMU51bWJlciA9TWF0aC5yb3VuZChNYXRoLnJhbmRvbSgpKTtcblx0dGhpcy5zd2l0Y2gyTnVtYmVyID0gTWF0aC5yb3VuZChNYXRoLnJhbmRvbSgpKTtcblx0dGhpcy5zd2l0Y2gzTnVtYmVyID0gTWF0aC5yb3VuZChNYXRoLnJhbmRvbSgpKTtcblx0dGhpcy5zd2l0Y2g0TnVtYmVyID0gTWF0aC5yb3VuZChNYXRoLnJhbmRvbSgpKTtcblx0Y29uc29sZS5sb2codGhpcy5zd2l0Y2gxTnVtYmVyICx0aGlzLnN3aXRjaDJOdW1iZXIgLCl0aGlzLnN3aXRjaDNOdW1iZXIgLHRoaXMuc3dpdGNoNE51bWJlclxuXHR9XG59Il0sInNvdXJjZVJvb3QiOiIvc291cmNlLyJ9

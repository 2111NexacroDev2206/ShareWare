(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("meetingRoom");
            this.set_titletext("New Form");
            if (Form == this.constructor)
            {
                this._setFormPosition(1280,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("ds_meetingRoom", this);
            obj.set_useclientlayout("true");
            obj._setContents("<ColumnInfo><Column id=\"memberNum\" type=\"STRING\" size=\"256\"/><Column id=\"meetingNo\" type=\"STRING\" size=\"256\"/><Column id=\"meetingDate\" type=\"STRING\" size=\"256\"/><Column id=\"meetingTime\" type=\"INT\" size=\"256\"/><Column id=\"meetingReservation\" type=\"DATE\" size=\"256\"/><Column id=\"memberName\" type=\"STRING\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"meetingTime\">10:00~12:00</Col></Row></Rows>");
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new Calendar("cal_meetingRoom","216","40","274","40",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            this.addChild(obj.name, obj);

            obj = new Button("btn_meetingRoom1","703","36","105","44",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_text("회의실1");
            obj.set_font("normal 16px/normal \"Arial\"");
            obj.set_cssclass("btn_meetingRoom");
            this.addChild(obj.name, obj);

            obj = new Button("btn_meetingRoom2","818","36","105","44",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            obj.set_text("회의실2");
            obj.set_font("normal 16px/normal \"Arial\"");
            obj.set_cssclass("btn_meetingRoom");
            this.addChild(obj.name, obj);

            obj = new Button("btn_meetingRoom3","933","36","105","44",null,null,null,null,null,null,this);
            obj.set_taborder("3");
            obj.set_text("회의실3");
            obj.set_font("normal 16px/normal \"Arial\"");
            obj.set_cssclass("btn_meetingRoom");
            this.addChild(obj.name, obj);

            obj = new Button("btn_meetingRoom4","1048","36","105","44",null,null,null,null,null,null,this);
            obj.set_taborder("4");
            obj.set_text("회의실4");
            obj.set_font("normal 16px/normal \"Arial\"");
            obj.set_cssclass("btn_meetingRoom");
            this.addChild(obj.name, obj);

            obj = new Button("btn_meetingRoom5","1163","36","105","44",null,null,null,null,null,null,this);
            obj.set_taborder("5");
            obj.set_text("회의실5");
            obj.set_font("normal 16px/normal \"Arial\"");
            obj.set_cssclass("btn_meetingRoom");
            this.addChild(obj.name, obj);

            obj = new Div("div_meetingRoom","703","150","549","240",null,null,null,null,null,null,this);
            obj.set_taborder("6");
            obj.set_text("Div01");
            this.addChild(obj.name, obj);

            obj = new Static("static_detaileTitle","5","2","295","49",null,null,null,null,null,null,this.div_meetingRoom.form);
            obj.set_taborder("0");
            obj.set_text("적정인원 및 포함기물");
            obj.set_font("700 20px/normal \"Arial\"");
            this.div_meetingRoom.addChild(obj.name, obj);

            obj = new Static("static_detaile1","20","50","282","29",null,null,null,null,null,null,this.div_meetingRoom.form);
            obj.set_taborder("1");
            obj.set_text("");
            obj.set_font("normal 10pt/normal \"Arial\"");
            this.div_meetingRoom.addChild(obj.name, obj);

            obj = new Static("static_detaile2","20","84","282","29",null,null,null,null,null,null,this.div_meetingRoom.form);
            obj.set_taborder("2");
            obj.set_font("normal 10pt/normal \"Arial\"");
            this.div_meetingRoom.addChild(obj.name, obj);

            obj = new Static("static_detaile3","20","118","282","29",null,null,null,null,null,null,this.div_meetingRoom.form);
            obj.set_taborder("3");
            obj.set_font("normal 10pt/normal \"Arial\"");
            this.div_meetingRoom.addChild(obj.name, obj);

            obj = new Static("static_detaile4","20","152","282","29",null,null,null,null,null,null,this.div_meetingRoom.form);
            obj.set_taborder("4");
            obj.set_font("normal 10pt/normal \"Arial\"");
            this.div_meetingRoom.addChild(obj.name, obj);

            obj = new Static("static_detaile5","20","186","282","29",null,null,null,null,null,null,this.div_meetingRoom.form);
            obj.set_taborder("5");
            obj.set_font("normal 10pt/normal \"Arial\"");
            this.div_meetingRoom.addChild(obj.name, obj);

            obj = new Static("satic_meetingRoom","50","96","274","63",null,null,null,null,null,null,this);
            obj.set_taborder("7");
            obj.set_font("normal 700 20px/normal \"Arial\"");
            obj.set_text("");
            this.addChild(obj.name, obj);

            obj = new Grid("Grid00","699","400","550","261",null,null,null,null,null,null,this);
            obj.set_taborder("8");
            obj.set_binddataset("ds_meetingRoom");
            obj.set_autofittype("col");
            obj.set_autosizingtype("none");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"80\"/><Column size=\"80\"/></Columns><Rows><Row size=\"43\" band=\"head\"/><Row size=\"43\"/></Rows><Band id=\"head\"><Cell text=\"예약시간\" font=\"normal 700 15px/normal &quot;Arial&quot;\" textAlign=\"center\"/><Cell col=\"1\" text=\"예약자\" font=\"normal 700 15px/normal &quot;Arial&quot;\" textAlign=\"center\"/></Band><Band id=\"body\"><Cell text=\"expr:meetingTime ==1? &quot;10:00~12:00&quot;:meetingTime ==2? &quot;13:00~15:00&quot;: meetingTime==3? &quot;15:00~17:00&quot;: meetingTime==4? &quot;17:00~19:00&quot;: &quot;19:00~21:00&quot;\" font=\"normal 15px/normal &quot;Arial&quot;\" textAlign=\"center\"/><Cell col=\"1\" text=\"bind:memberNum\" font=\"normal 15px/normal &quot;Arial&quot;\" textAlign=\"center\"/></Band></Format></Formats>");
            this.addChild(obj.name, obj);

            obj = new ImageViewer("img_view1","99","159","500","500",null,null,"500","500","500","500",this);
            obj.set_taborder("9");
            this.addChild(obj.name, obj);

            obj = new Static("Static00","60","30","120","60",null,null,null,null,null,null,this);
            obj.set_taborder("10");
            obj.set_text("날짜 선택");
            obj.set_font("normal 700 17pt/normal \"Arial\"");
            this.addChild(obj.name, obj);
            // Layout Functions
            //-- Default Layout : this
            obj = new Layout("default","",1280,720,this,function(p){});
            this.addLayout(obj.name, obj);
            
            // BindItem Information

            
            // TriggerItem Information

        };
        
        this.loadPreloadList = function()
        {

        };
        
        // User Script
        this.registerScript("meetingRoom.xfdl", function() {

        this.btn_meetingRoom1_onclick = function(obj,e)
        {
        	this.img_view1.set_image("imagerc::meetingRoom1.png");
        	var selectDate = this.cal_meetingRoom.getYear().toString().padLeft(4, "0") + this.cal_meetingRoom.getMonth().toString().padLeft(2, "0") + this.cal_meetingRoom.getDay().toString().padLeft(2, "0");
        	this.transaction(
        	"meetingRoom_Btn1"
        	,"SW::admin/meetingRoom/view.sw"//URL
        	,"" //I,U,D 보내는 데이터
        	,"ds_meetingRoom=out_meetingRoomData"//select 데이터
        	,"meetingDate=" + selectDate + " meetingNo=" + "1 회의실"
        	,"fn_callback_tran"//완료시 호출되는 함수
        	)
        	this.satic_meetingRoom.set_text("▶ 1 회의실");
        	this.div_meetingRoom.form.static_detaile1.set_text("- 적정인원  10인");
        	this.div_meetingRoom.form.static_detaile2.set_text("- 빔프로젝트");
        	this.div_meetingRoom.form.static_detaile3.set_text("- 노트북");
        	this.div_meetingRoom.form.static_detaile4.set_text("- 화이트보드");
        	this.div_meetingRoom.form.static_detaile5.set_text("");

        };


        this.btn_meetingRoom2_onclick = function(obj,e)
        {
        	this.img_view1.set_image("imagerc::meetingRoom2.jpg");
        	var selectDate = this.cal_meetingRoom.getYear().toString().padLeft(4, "0") + this.cal_meetingRoom.getMonth().toString().padLeft(2, "0") + this.cal_meetingRoom.getDay().toString().padLeft(2, "0");
        	this.transaction(
        	"meetingRoom_Btn2"
        	,"SW::admin/meetingRoom/view.sw"//URL
        	,"" //I,U,D 보내는 데이터
        	,"ds_meetingRoom=out_meetingRoomData"//select 데이터
        	,"meetingDate=" + selectDate + " meetingNo=" + "2 회의실"
        	,"fn_callback_btn"//완료시 호출되는 함수
        	)
        	this.satic_meetingRoom.set_text("▶ 2 회의실");
        	this.div_meetingRoom.form.static_detaile1.set_text("- 적정인원  10인");
        	this.div_meetingRoom.form.static_detaile2.set_text("- 빔프로젝트");
        	this.div_meetingRoom.form.static_detaile3.set_text("- 노트북");
        	this.div_meetingRoom.form.static_detaile4.set_text("- 화이트보드");
        	this.div_meetingRoom.form.static_detaile5.set_text("");
        };


        this.btn_meetingRoom3_onclick = function(obj,e)
        {
        	this.img_view1.set_image("imagerc::meetingRoom3.jpg");

        	var selectDate = this.cal_meetingRoom.getYear().toString().padLeft(4, "0") + this.cal_meetingRoom.getMonth().toString().padLeft(2, "0") + this.cal_meetingRoom.getDay().toString().padLeft(2, "0");
        	this.transaction(
        	"meetingRoom_Btn3"
        	,"SW::admin/meetingRoom/view.sw"//URL
        	,"" //I,U,D 보내는 데이터
        	,"ds_meetingRoom=out_meetingRoomData"//select 데이터
        	,"meetingDate=" + selectDate + " meetingNo=" + "3 회의실"
        	,"fn_callback_btn"//완료시 호출되는 함수
        	)
        	this.satic_meetingRoom.set_text("▶ 3 회의실");
        	this.div_meetingRoom.form.static_detaile1.set_text("- 적정인원  7인");
        	this.div_meetingRoom.form.static_detaile2.set_text("- 24인치 TV");
        	this.div_meetingRoom.form.static_detaile3.set_text("- 노트북");
        	this.div_meetingRoom.form.static_detaile4.set_text("- 화이트보드");
        	this.div_meetingRoom.form.static_detaile5.set_text("");

        };

        this.btn_meetingRoom4_onclick = function(obj,e)
        {
        	this.img_view1.set_image("imagerc::meetingRoom4.jpg");

        	var selectDate = this.cal_meetingRoom.getYear().toString().padLeft(4, "0") + this.cal_meetingRoom.getMonth().toString().padLeft(2, "0") + this.cal_meetingRoom.getDay().toString().padLeft(2, "0");
        	this.transaction(
        	"meetingRoom_Btn4"
        	,"SW::admin/meetingRoom/view.sw"//URL
        	,"" //I,U,D 보내는 데이터
        	,"ds_meetingRoom=out_meetingRoomData"//select 데이터
        	,"meetingDate=" + selectDate + " meetingNo=" + "4 회의실"
        	,"fn_callback_btn"//완료시 호출되는 함수
        	)
        	this.satic_meetingRoom.set_text("▶ 4 회의실");
        	this.div_meetingRoom.form.static_detaile1.set_text("- 적정인원  15인");
        	this.div_meetingRoom.form.static_detaile2.set_text("- 빔프로젝트");
        	this.div_meetingRoom.form.static_detaile3.set_text("- 노트북");
        	this.div_meetingRoom.form.static_detaile4.set_text("- 스피커");
        	this.div_meetingRoom.form.static_detaile5.set_text("- 화이트보드");
        };

        this.btn_meetingRoom5_onclick = function(obj,e)
        {

        	this.img_view1.set_image("imagerc::meetingRoom5.jpg");

        	var selectDate = this.cal_meetingRoom.getYear().toString().padLeft(4, "0") + this.cal_meetingRoom.getMonth().toString().padLeft(2, "0") + this.cal_meetingRoom.getDay().toString().padLeft(2, "0");
        	this.transaction(
        	"meetingRoom_Btn5"
        	,"SW::admin/meetingRoom/view.sw"//URL
        	,"" //I,U,D 보내는 데이터
        	,"ds_meetingRoom=out_meetingRoomData"//select 데이터
        	,"meetingDate=" + selectDate + " meetingNo=" + "5 회의실"
        	,"fn_callback_btn"//완료시 호출되는 함수
        	)
        	this.satic_meetingRoom.set_text("▶ 5 회의실");
        	this.div_meetingRoom.form.static_detaile1.set_text("- 적정인원  6인");
        	this.div_meetingRoom.form.static_detaile2.set_text("- 24인치 TV");
        	this.div_meetingRoom.form.static_detaile3.set_text("- 노트북");
        	this.div_meetingRoom.form.static_detaile4.set_text("- 스피커");
        	this.div_meetingRoom.form.static_detaile5.set_text("- 화이트보드");
        };

        this.meetingRoom_onload = function(obj,e)
        {
        	this.satic_meetingRoom.set_text("▶ 1 회의실");
        	this.div_meetingRoom.form.static_detaile1.set_text("- 적정인원  10인");
        	this.div_meetingRoom.form.static_detaile2.set_text("- 빔프로젝트");
        	this.div_meetingRoom.form.static_detaile3.set_text("- 노트북");
        	this.div_meetingRoom.form.static_detaile4.set_text("- 화이트보드");
        	this.div_meetingRoom.form.static_detaile5.set_text("");
        	this.img_view1.set_image("imagerc::meetingRoom1.png");

        	var currDate = new Date();
        	var year = currDate.getFullYear().toString().padLeft(4, "0");
        	var month = (currDate.getMonth()+1).toString().padLeft(2, "0");
        	var day = currDate.getDate().toString().padLeft(2, "0");

        	this.cal_meetingRoom.set_value(year+month+day);

        	var meetingRoom = year + month + day;


        	this.transaction(
        	"meetingRoom_Onload"
        	,"SW::admin/meetingRoom/view.sw"//URL
        	,"" //I,U,D 보내는 데이터
        	,"ds_meetingRoom=out_meetingRoomData"//select 데이터
        	,"meetingDate=" + meetingRoom + " meetingNo=" + "1 회의실"
        	,"fn_callback_tran"//완료시 호출되는 함수
        	)


        };

        this.cal_meetingRoom_onchanged = function(obj,e)
        {
        	this.satic_meetingRoom.set_text("▶ 1 회의실");
        	this.div_meetingRoom.form.static_detaile1.set_text("- 적정인원  10인");
        	this.div_meetingRoom.form.static_detaile2.set_text("- 빔프로젝트");
        	this.div_meetingRoom.form.static_detaile3.set_text("- 노트북");
        	this.div_meetingRoom.form.static_detaile4.set_text("- 화이트보드");
        	this.div_meetingRoom.form.static_detaile5.set_text("");
        	var selectDate = this.cal_meetingRoom.getYear().toString().padLeft(4, "0") + this.cal_meetingRoom.getMonth().toString().padLeft(2, "0") + this.cal_meetingRoom.getDay().toString().padLeft(2, "0");
        	this.transaction(
        	"meetingRoom_Onchanged"
        	,"SW::admin/meetingRoom/view.sw"//URL
        	,"" //I,U,D 보내는 데이터
        	,"ds_meetingRoom=out_meetingRoomData"//select 데이터
        	,"meetingDate=" + selectDate + " meetingNo=" + nexacro.wrapQuote("1 회의실")
        	,"fn_callback_tran"//완료시 호출되는 함수
        	)

        };


        this.out_var="";
        this.fn_callback_tran = function(id, nErrorCode, sErrorMsg)
        {
        	if(id=="meetingRoom_Onload" || id=="meetingRoom_Onchanged")
        	{
        		if(nErrorCode < 0)
        		{
        			this.alert("조회 실패 : " + sErrorMsg);
        			return;
        		}
        	}
        };

        this.fn_callback_btn = function(id, nErrorCode, sErrorMsg)
        {
        	if(id=="meetingRoom_Btn1" || id=="meetingRoom_Btn2" || id =="meetingRoom_Btn3" || id=="meetingRoom_Btn4" || id =="meetingRoom_Btn5")
        	{
        		if(nErrorCode < 0)
        		{
        			this.alert("조회 실패 : " + sErrorMsg);
        			return;
        		}
        	}
        };

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.addEventHandler("onload",this.meetingRoom_onload,this);
            this.cal_meetingRoom.addEventHandler("onchanged",this.cal_meetingRoom_onchanged,this);
            this.btn_meetingRoom1.addEventHandler("onclick",this.btn_meetingRoom1_onclick,this);
            this.btn_meetingRoom2.addEventHandler("onclick",this.btn_meetingRoom2_onclick,this);
            this.btn_meetingRoom3.addEventHandler("onclick",this.btn_meetingRoom3_onclick,this);
            this.btn_meetingRoom4.addEventHandler("onclick",this.btn_meetingRoom4_onclick,this);
            this.btn_meetingRoom5.addEventHandler("onclick",this.btn_meetingRoom5_onclick,this);
            this.div_meetingRoom.form.static_detaileTitle.addEventHandler("onclick",this.Div01_static_detaileTitle_onclick,this);
            this.div_meetingRoom.form.static_detaile1.addEventHandler("onclick",this.div_meetingRoom_static_detaile1_onclick,this);
            this.div_meetingRoom.form.static_detaile2.addEventHandler("onclick",this.div_meetingRoom_static_detaile2_onclick,this);
            this.satic_meetingRoom.addEventHandler("onclick",this.Static01_onclick,this);
        };
        this.loadIncludeScript("meetingRoom.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();

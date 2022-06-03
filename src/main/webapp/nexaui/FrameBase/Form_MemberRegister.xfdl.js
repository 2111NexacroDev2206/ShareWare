(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("Form_MemberRegister");
            this.set_titletext("New Form");
            if (Form == this.constructor)
            {
                this._setFormPosition(1280,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("ds_member", this);
            obj._setContents("<ColumnInfo><Column id=\"memberNum\" type=\"STRING\" size=\"256\"/><Column id=\"memberName\" type=\"STRING\" size=\"256\"/><Column id=\"divCode\" type=\"STRING\" size=\"256\"/><Column id=\"division\" type=\"STRING\" size=\"256\"/><Column id=\"rankCode\" type=\"STRING\" size=\"256\"/><Column id=\"rank\" type=\"STRING\" size=\"256\"/><Column id=\"address\" type=\"STRING\" size=\"256\"/><Column id=\"phone\" type=\"STRING\" size=\"256\"/><Column id=\"mail\" type=\"STRING\" size=\"256\"/><Column id=\"hireDate\" type=\"DATE\" size=\"256\"/><Column id=\"retireDate\" type=\"DATE\" size=\"256\"/><Column id=\"birth\" type=\"DATE\" size=\"256\"/><Column id=\"account\" type=\"STRING\" size=\"256\"/><Column id=\"bank\" type=\"STRING\" size=\"256\"/><Column id=\"password\" type=\"STRING\" size=\"256\"/><Column id=\"gender\" type=\"STRING\" size=\"256\"/><Column id=\"photo\" type=\"STRING\" size=\"256\"/><Column id=\"breakTotal\" type=\"INT\" size=\"256\"/></ColumnInfo><Rows><Row/></Rows>");
            this.addChild(obj.name, obj);


            obj = new Dataset("ds_division", this);
            obj._setContents("<ColumnInfo><Column id=\"divCode\" type=\"STRING\" size=\"256\"/><Column id=\"divName\" type=\"STRING\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"divCode\">2511</Col><Col id=\"divName\">영업부</Col></Row><Row><Col id=\"divCode\">4112</Col><Col id=\"divName\">인사팀</Col></Row><Row><Col id=\"divCode\">3011</Col><Col id=\"divName\">기획팀</Col></Row><Row><Col id=\"divCode\">2458</Col><Col id=\"divName\">회계팀</Col></Row><Row><Col id=\"divCode\">7745</Col><Col id=\"divName\">총무팀</Col></Row><Row><Col id=\"divCode\">3655</Col><Col id=\"divName\">개발1팀</Col></Row><Row><Col id=\"divCode\">1000</Col><Col id=\"divName\">임원</Col></Row><Row><Col id=\"divCode\">2512</Col><Col id=\"divName\">국내영업팀</Col></Row><Row><Col id=\"divCode\">5112</Col><Col id=\"divName\">인사부</Col></Row><Row><Col id=\"divCode\">4655</Col><Col id=\"divName\">인프라운영부</Col></Row><Row><Col id=\"divCode\">4666</Col><Col id=\"divName\">고객기술지원팀</Col></Row><Row><Col id=\"divCode\">4677</Col><Col id=\"divName\">서비스지원팀</Col></Row><Row><Col id=\"divCode\">3666</Col><Col id=\"divName\">개발2팀</Col></Row><Row><Col id=\"divCode\">4011</Col><Col id=\"divName\">기획부</Col></Row><Row><Col id=\"divCode\">3458</Col><Col id=\"divName\">경영지원부</Col></Row><Row><Col id=\"divCode\">2510</Col><Col id=\"divName\">마케팅팀</Col></Row></Rows>");
            this.addChild(obj.name, obj);


            obj = new Dataset("ds_rank", this);
            obj._setContents("<ColumnInfo><Column id=\"rankCode\" type=\"STRING\" size=\"256\"/><Column id=\"rankName\" type=\"STRING\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"rankCode\">1111</Col><Col id=\"rankName\">임원</Col></Row><Row><Col id=\"rankCode\">1122</Col><Col id=\"rankName\">부장</Col></Row><Row><Col id=\"rankCode\">1133</Col><Col id=\"rankName\">과장</Col></Row><Row><Col id=\"rankCode\">1144</Col><Col id=\"rankName\">대리</Col></Row><Row><Col id=\"rankCode\">1155</Col><Col id=\"rankName\">사원</Col></Row></Rows>");
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new Div("Div00","100","30","1080","650",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_text("Div00");
            this.addChild(obj.name, obj);

            obj = new Static("stc_memberName","540","10","150","50",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("0");
            obj.set_text("이름");
            obj.set_textAlign("center");
            obj.set_background("#e0e0e0");
            obj.set_border("1px solid darkgray");
            obj.set_font("normal 13pt/normal \"Arial\"");
            this.Div00.addChild(obj.name, obj);

            obj = new Static("stc_memberNum","540","60","150","50",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("1");
            obj.set_text("사원번호");
            obj.set_textAlign("center");
            obj.set_background("#e0e0e0");
            obj.set_border("1px solid darkgray");
            obj.set_font("normal 13pt/normal \"Arial\"");
            this.Div00.addChild(obj.name, obj);

            obj = new Static("stc_divName","540","110","150","50",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("2");
            obj.set_text("부서");
            obj.set_textAlign("center");
            obj.set_background("#e0e0e0");
            obj.set_border("1px solid darkgray");
            obj.set_font("normal 13pt/normal \"Arial\"");
            this.Div00.addChild(obj.name, obj);

            obj = new Static("stc_rankName","540","160","150","50",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("3");
            obj.set_text("직급");
            obj.set_textAlign("center");
            obj.set_background("#e0e0e0");
            obj.set_border("1px solid darkgray");
            obj.set_font("normal 13pt/normal \"Arial\"");
            this.Div00.addChild(obj.name, obj);

            obj = new Static("stc_address","540","210","150","50",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("4");
            obj.set_text("주소");
            obj.set_textAlign("center");
            obj.set_background("#e0e0e0");
            obj.set_border("1px solid darkgray");
            obj.set_font("normal 13pt/normal \"Arial\"");
            this.Div00.addChild(obj.name, obj);

            obj = new Static("stc_phone","540","260","150","50",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("5");
            obj.set_text("전화번호");
            obj.set_textAlign("center");
            obj.set_background("#e0e0e0");
            obj.set_border("1px solid darkgray");
            obj.set_font("normal 13pt/normal \"Arial\"");
            obj.getSetter("onchanged").set("Common_onchanged");
            this.Div00.addChild(obj.name, obj);

            obj = new Static("stc_mail","540","310","150","50",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("6");
            obj.set_text("이메일");
            obj.set_textAlign("center");
            obj.set_background("#e0e0e0");
            obj.set_border("1px solid darkgray");
            obj.set_font("normal 13pt/normal \"Arial\"");
            this.Div00.addChild(obj.name, obj);

            obj = new Edit("memberName","690","10","350","50",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("7");
            obj.set_border("1px solid darkgray");
            obj.set_font("normal 13pt/normal \"Arial\"");
            obj.set_textAlign("center");
            this.Div00.addChild(obj.name, obj);

            obj = new Edit("memberNum","690","60","350","50",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("8");
            obj.set_border("1px solid darkgray");
            obj.set_font("normal 13pt/normal \"Arial\"");
            obj.set_textAlign("center");
            this.Div00.addChild(obj.name, obj);

            obj = new Combo("divName","690","110","350","50",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("9");
            obj.set_border("1px solid darkgray");
            obj.set_font("normal 13pt/normal \"Arial\"");
            obj.set_innerdataset("ds_division");
            obj.set_codecolumn("divCode");
            obj.set_datacolumn("divName");
            obj.set_text("Combo00");
            this.Div00.addChild(obj.name, obj);

            obj = new Combo("rankName","690","160","350","50",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("10");
            obj.set_border("1px solid darkgray");
            obj.set_font("normal 13pt/normal \"Arial\"");
            obj.set_innerdataset("ds_rank");
            obj.set_codecolumn("rankCode");
            obj.set_datacolumn("rankName");
            obj.set_text("Combo00");
            this.Div00.addChild(obj.name, obj);

            obj = new Edit("address","690","210","350","50",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("11");
            obj.set_border("1px solid darkgray");
            obj.set_font("normal 13pt/normal \"Arial\"");
            obj.set_textAlign("center");
            this.Div00.addChild(obj.name, obj);

            obj = new Edit("mail","690","310","350","50",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("12");
            obj.set_border("1px solid darkgray");
            obj.set_font("normal 13pt/normal \"Arial\"");
            obj.set_textAlign("center");
            this.Div00.addChild(obj.name, obj);

            obj = new Static("stc_hireDate","40","360","150","50",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("13");
            obj.set_text("입사일");
            obj.set_textAlign("center");
            obj.set_background("#e0e0e0");
            obj.set_border("1px solid darkgray");
            obj.set_font("normal 13pt/normal \"Arial\"");
            this.Div00.addChild(obj.name, obj);

            obj = new Static("stc_birth","40","410","150","50",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("14");
            obj.set_text("생년월일");
            obj.set_textAlign("center");
            obj.set_background("#e0e0e0");
            obj.set_border("1px solid darkgray");
            obj.set_font("normal 13pt/normal \"Arial\"");
            this.Div00.addChild(obj.name, obj);

            obj = new Static("stc_account","40","460","150","50",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("15");
            obj.set_text("계좌");
            obj.set_textAlign("center");
            obj.set_background("#e0e0e0");
            obj.set_border("1px solid darkgray");
            obj.set_font("normal 13pt/normal \"Arial\"");
            this.Div00.addChild(obj.name, obj);

            obj = new Edit("account","190","460","350","50",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("16");
            obj.set_border("1px solid darkgray");
            obj.set_font("normal 13pt/normal \"Arial\"");
            obj.set_textAlign("center");
            this.Div00.addChild(obj.name, obj);

            obj = new Static("stc_password","40","510","150","50",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("17");
            obj.set_text("임시 비밀번호");
            obj.set_textAlign("center");
            obj.set_background("#e0e0e0");
            obj.set_border("1px solid darkgray");
            obj.set_font("normal 13pt/normal \"Arial\"");
            this.Div00.addChild(obj.name, obj);

            obj = new Edit("password","190","510","350","50",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("18");
            obj.set_border("1px solid darkgray");
            obj.set_font("normal 13pt/normal \"Arial\"");
            obj.set_textAlign("center");
            obj.set_password("true");
            this.Div00.addChild(obj.name, obj);

            obj = new Static("stc_retireDate","540","360","150","50",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("19");
            obj.set_text("퇴사일");
            obj.set_textAlign("center");
            obj.set_background("#e0e0e0");
            obj.set_border("1px solid darkgray");
            obj.set_font("normal 13pt/normal \"Arial\"");
            this.Div00.addChild(obj.name, obj);

            obj = new Static("stc_gender","540","410","150","50",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("20");
            obj.set_text("성별");
            obj.set_textAlign("center");
            obj.set_background("#e0e0e0");
            obj.set_border("1px solid darkgray");
            obj.set_font("normal 13pt/normal \"Arial\"");
            this.Div00.addChild(obj.name, obj);

            obj = new Static("stc_bank","540","460","150","50",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("21");
            obj.set_text("은행");
            obj.set_textAlign("center");
            obj.set_background("#e0e0e0");
            obj.set_border("1px solid darkgray");
            obj.set_font("normal 13pt/normal \"Arial\"");
            this.Div00.addChild(obj.name, obj);

            obj = new Combo("bank","690","460","350","50",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("22");
            obj.set_border("1px solid darkgray");
            obj.set_font("normal 13pt/normal \"Arial\"");
            obj.set_codecolumn("codecolumn");
            obj.set_datacolumn("datacolumn");
            var Div00_form_bank_innerdataset = new nexacro.NormalDataset("Div00_form_bank_innerdataset", obj);
            Div00_form_bank_innerdataset._setContents("<ColumnInfo><Column id=\"codecolumn\" size=\"256\"/><Column id=\"datacolumn\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"codecolumn\">기업</Col><Col id=\"datacolumn\">기업</Col></Row><Row><Col id=\"codecolumn\">국민</Col><Col id=\"datacolumn\">국민</Col></Row><Row><Col id=\"codecolumn\">농협</Col><Col id=\"datacolumn\">농협</Col></Row><Row><Col id=\"codecolumn\">수협</Col><Col id=\"datacolumn\">수협</Col></Row><Row><Col id=\"codecolumn\">경남</Col><Col id=\"datacolumn\">경남</Col></Row><Row><Col id=\"codecolumn\">우체국</Col><Col id=\"datacolumn\">우체국</Col></Row><Row><Col id=\"codecolumn\">카카오뱅크</Col><Col id=\"datacolumn\">카카오뱅크</Col></Row><Row><Col id=\"codecolumn\">K뱅크</Col><Col id=\"datacolumn\">K뱅크</Col></Row></Rows>");
            obj.set_innerdataset(Div00_form_bank_innerdataset);
            obj.set_text("Combo00");
            this.Div00.addChild(obj.name, obj);

            obj = new Radio("gender","690","410","350","50",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("23");
            obj.set_background("#ffffff");
            obj.set_border("1px solid darkgray");
            obj.set_font("normal 13pt/normal \"Arial\"");
            obj.set_codecolumn("codecolumn");
            obj.set_datacolumn("datacolumn");
            obj.set_direction("vertical");
            obj.set_padding("0px 0px 0px 80px");
            var Div00_form_gender_innerdataset = new nexacro.NormalDataset("Div00_form_gender_innerdataset", obj);
            Div00_form_gender_innerdataset._setContents("<ColumnInfo><Column id=\"codecolumn\" size=\"256\"/><Column id=\"datacolumn\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"codecolumn\">M</Col><Col id=\"datacolumn\">남</Col></Row><Row><Col id=\"codecolumn\">F</Col><Col id=\"datacolumn\">여</Col></Row></Rows>");
            obj.set_innerdataset(Div00_form_gender_innerdataset);
            this.Div00.addChild(obj.name, obj);

            obj = new Static("stc_breakTotal","540","510","150","50",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("24");
            obj.set_text("총 연차수");
            obj.set_textAlign("center");
            obj.set_background("#e0e0e0");
            obj.set_border("1px solid darkgray");
            obj.set_font("normal 13pt/normal \"Arial\"");
            this.Div00.addChild(obj.name, obj);

            obj = new Calendar("hireDate","190","360","350","50",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("25");
            obj.set_border("1px solid darkgray");
            obj.set_font("normal 13pt/normal \"Arial\"");
            this.Div00.addChild(obj.name, obj);

            obj = new Calendar("retireDate","690","360","350","50",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("26");
            obj.set_border("1px solid darkgray");
            obj.set_font("normal 13pt/normal \"Arial\"");
            this.Div00.addChild(obj.name, obj);

            obj = new Calendar("birth","190","410","350","50",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("27");
            obj.set_border("1px solid darkgray");
            obj.set_font("normal 13pt/normal \"Arial\"");
            this.Div00.addChild(obj.name, obj);

            obj = new MaskEdit("phone","690","260","350","50",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("28");
            obj.set_border("1px solid darkgray");
            obj.set_font("normal 13pt/normal \"Arial\"");
            obj.set_type("string");
            obj.set_format("###########");
            obj.set_textAlign("center");
            this.Div00.addChild(obj.name, obj);

            obj = new MaskEdit("breakTotal","690","510","350","50",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("29");
            obj.set_border("1px solid darkgray");
            obj.set_font("normal 13pt/normal \"Arial\"");
            obj.set_type("number");
            obj.set_textAlign("center");
            this.Div00.addChild(obj.name, obj);

            obj = new ImageViewer("ImageViewer00","40","10","490","310",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("30");
            obj.set_stretch("fixaspectratio");
            this.Div00.addChild(obj.name, obj);

            obj = new FileUpload("fileupload","40","330","490","30",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("31");
            obj.set_font("normal 13pt/normal \"Arial\"");
            this.Div00.addChild(obj.name, obj);

            obj = new Button("btn_register","1000","610","140","50",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_text("등록");
            obj.set_font("normal 13pt/normal \"Arial\"");
            this.addChild(obj.name, obj);
            // Layout Functions
            //-- Default Layout : this
            obj = new Layout("default","",1280,720,this,function(p){});
            obj.set_mobileorientation("landscape");
            this.addLayout(obj.name, obj);
            
            // BindItem Information
            obj = new BindItem("item0","Div00.form.memberNum","value","ds_member","memberNum");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item1","Div00.form.memberName","value","ds_member","memberName");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item2","Div00.form.divName","value","ds_member","division");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item3","Div00.form.rankName","value","ds_member","rank");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item4","Div00.form.address","value","ds_member","address");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item5","Div00.form.phone","value","ds_member","phone");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item6","Div00.form.mail","value","ds_member","mail");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item7","Div00.form.hireDate","value","ds_member","hireDate");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item8","Div00.form.retireDate","value","ds_member","retireDate");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item9","Div00.form.birth","value","ds_member","birth");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item10","Div00.form.account","value","ds_member","account");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item11","Div00.form.bank","value","ds_member","bank");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item12","Div00.form.password","value","ds_member","password");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item13","Div00.form.gender","value","ds_member","gender");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item14","Div00.form.breakTotal","value","ds_member","breakTotal");
            this.addChild(obj.name, obj);
            obj.bind();
            
            // TriggerItem Information

        };
        
        this.loadPreloadList = function()
        {

        };
        
        // User Script
        this.registerScript("Form_MemberRegister.xfdl", function() {
        // 등록 버튼
        this.btn_register_onclick = function(obj,e)
        {
        	this.transaction(
        			"member_save" // 1. ID
        			, "SW::admin/member/register.sw" // 2. URL
        			, "member=ds_member:A" // 3. InDs : F->S jsp(I, U, D)
        			, "" // 4. OutDs : S->F jsp(SELECT) - 스페이스는 구분자라서 = 옆에 스페이스 없이 써야 함
        			, "" // 5. InVar : F->S(var)
        			, "fn_callback_tran" // 6. callback function(transaction 완료 시 호출되는 함수)
        		);
        };

        this.fn_callback_tran = function(id, nErrorCode, sErrorMsg)
        {
        	if(id=="member_save")
        	{
        		if(nErrorCode < 0)
        		{
        			this.alert("사원 등록 실패 : " + sErrorMsg);
        			return;
        		}else {
        			this.go("FrameBase::Form_MemberList.xfdl");
        		}
        	}
        }

        this.Div00_fileupload_onitemchanged = function(obj,e)
        {
        	this.Div00.form.ImageViewer00.set_image("URL('file://" + obj.text + "')");
        	this.ds_member.setColumn(0, "photo", obj.text);
        };
        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.Div00.form.breakTotal.addEventHandler("onchanged",this.Div00_breakTotal_onchanged,this);
            this.Div00.form.fileupload.addEventHandler("onitemchanged",this.Div00_fileupload_onitemchanged,this);
            this.btn_register.addEventHandler("onclick",this.btn_register_onclick,this);
        };
        this.loadIncludeScript("Form_MemberRegister.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();

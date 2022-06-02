(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("Form_MemberList");
            this.set_titletext("New Form");
            if (Form == this.constructor)
            {
                this._setFormPosition(1280,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("ds_member", this);
            obj._setContents("<ColumnInfo><Column id=\"memberNum\" type=\"STRING\" size=\"256\"/><Column id=\"memberName\" type=\"STRING\" size=\"256\"/><Column id=\"divCode\" type=\"STRING\" size=\"256\"/><Column id=\"division\" type=\"STRING\" size=\"256\"/><Column id=\"rankCode\" type=\"STRING\" size=\"256\"/><Column id=\"rank\" type=\"STRING\" size=\"256\"/><Column id=\"address\" type=\"STRING\" size=\"256\"/><Column id=\"phone\" type=\"STRING\" size=\"256\"/><Column id=\"mail\" type=\"STRING\" size=\"256\"/><Column id=\"hireDate\" type=\"DATE\" size=\"256\"/><Column id=\"retireDate\" type=\"DATE\" size=\"256\"/><Column id=\"birth\" type=\"STRING\" size=\"256\"/><Column id=\"account\" type=\"STRING\" size=\"256\"/><Column id=\"bank\" type=\"STRING\" size=\"256\"/><Column id=\"password\" type=\"STRING\" size=\"256\"/><Column id=\"gender\" type=\"STRING\" size=\"256\"/><Column id=\"photo\" type=\"STRING\" size=\"256\"/><Column id=\"breakTotal\" type=\"FLOAT\" size=\"256\"/></ColumnInfo>");
            this.addChild(obj.name, obj);


            obj = new Dataset("ds_division", this);
            obj._setContents("<ColumnInfo><Column id=\"divCode\" type=\"STRING\" size=\"256\"/><Column id=\"divName\" type=\"STRING\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"divCode\">2511</Col><Col id=\"divName\">영업부</Col></Row><Row><Col id=\"divCode\">4112</Col><Col id=\"divName\">인사팀</Col></Row><Row><Col id=\"divCode\">3011</Col><Col id=\"divName\">기획팀</Col></Row><Row><Col id=\"divCode\">2458</Col><Col id=\"divName\">회계팀</Col></Row><Row><Col id=\"divCode\">7745</Col><Col id=\"divName\">총무팀</Col></Row><Row><Col id=\"divCode\">3655</Col><Col id=\"divName\">개발1팀</Col></Row><Row><Col id=\"divCode\">1000</Col><Col id=\"divName\">임원</Col></Row><Row><Col id=\"divCode\">2512</Col><Col id=\"divName\">국내영업팀</Col></Row><Row><Col id=\"divCode\">5112</Col><Col id=\"divName\">인사부</Col></Row><Row><Col id=\"divCode\">4655</Col><Col id=\"divName\">인프라운영부</Col></Row><Row><Col id=\"divCode\">4666</Col><Col id=\"divName\">고객기술지원팀</Col></Row><Row><Col id=\"divCode\">4677</Col><Col id=\"divName\">서비스지원팀</Col></Row><Row><Col id=\"divCode\">3666</Col><Col id=\"divName\">개발2팀</Col></Row><Row><Col id=\"divCode\">4011</Col><Col id=\"divName\">기획부</Col></Row><Row><Col id=\"divCode\">3458</Col><Col id=\"divName\">경영지원부</Col></Row><Row><Col id=\"divCode\">2510</Col><Col id=\"divName\">마케팅팀</Col></Row></Rows>");
            this.addChild(obj.name, obj);


            obj = new Dataset("ds_rank", this);
            obj._setContents("<ColumnInfo><Column id=\"rankCode\" type=\"STRING\" size=\"256\"/><Column id=\"rankName\" type=\"STRING\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"rankCode\">1111</Col><Col id=\"rankName\">임원</Col></Row><Row><Col id=\"rankCode\">1122</Col><Col id=\"rankName\">부장</Col></Row><Row><Col id=\"rankCode\">1133</Col><Col id=\"rankName\">과장</Col></Row><Row><Col id=\"rankCode\">1144</Col><Col id=\"rankName\">대리</Col></Row><Row><Col id=\"rankCode\">1155</Col><Col id=\"rankName\">사원</Col></Row></Rows>");
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new Grid("Grid00","60","160","1160","440",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_binddataset("ds_member");
            obj.set_autofittype("col");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"50\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/></Columns><Rows><Row size=\"30\" band=\"head\"/><Row size=\"50\"/></Rows><Band id=\"head\"><Cell text=\"사진\"/><Cell col=\"1\" text=\"사원번호\"/><Cell col=\"2\" text=\"이름\"/><Cell col=\"3\" text=\"부서\"/><Cell col=\"4\" text=\"직급\"/><Cell col=\"5\" text=\"메일\"/><Cell col=\"6\" text=\"전화번호\"/></Band><Band id=\"body\"><Cell displaytype=\"imagecontrol\" text=\"expr:&quot;theme://images/&quot; + photo\" imagestretch=\"fixaspectratio\"/><Cell col=\"1\" text=\"bind:memberNum\"/><Cell col=\"2\" text=\"bind:memberName\"/><Cell col=\"3\" text=\"bind:division\"/><Cell col=\"4\" text=\"bind:rank\"/><Cell col=\"5\" text=\"bind:mail\"/><Cell col=\"6\" text=\"bind:phone\"/></Band></Format></Formats>");
            this.addChild(obj.name, obj);

            obj = new Button("Button00","1100","95","120","50",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_text("사원 등록");
            obj.set_font("normal 13pt/normal \"Arial\"");
            this.addChild(obj.name, obj);

            obj = new Button("btn_all","60","110","50","45",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            obj.set_text("전체");
            obj.set_cssclass("filter");
            this.addChild(obj.name, obj);

            obj = new Button("btn_exist","130","110","50","45",null,null,null,null,null,null,this);
            obj.set_taborder("3");
            obj.set_text("재직");
            obj.set_cssclass("filter");
            this.addChild(obj.name, obj);

            obj = new Button("btn_noExist","200","110","50","45",null,null,null,null,null,null,this);
            obj.set_taborder("4");
            obj.set_text("퇴직");
            obj.set_cssclass("filter");
            this.addChild(obj.name, obj);

            obj = new Combo("searchCondition","850","618","90","40",null,null,null,null,null,null,this);
            obj.set_taborder("5");
            obj.set_codecolumn("codecolumn");
            obj.set_datacolumn("datacolumn");
            var searchCondition_innerdataset = new nexacro.NormalDataset("searchCondition_innerdataset", obj);
            searchCondition_innerdataset._setContents("<ColumnInfo><Column id=\"codecolumn\" size=\"256\"/><Column id=\"datacolumn\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"codecolumn\">all</Col><Col id=\"datacolumn\">전체</Col></Row><Row><Col id=\"datacolumn\">이름</Col><Col id=\"codecolumn\">memberName</Col></Row><Row><Col id=\"datacolumn\">부서</Col><Col id=\"codecolumn\">division</Col></Row><Row><Col id=\"datacolumn\">직급</Col><Col id=\"codecolumn\">rank</Col></Row></Rows>");
            obj.set_innerdataset(searchCondition_innerdataset);
            obj.set_text("전체");
            obj.set_value("all");
            obj.set_index("0");
            this.addChild(obj.name, obj);

            obj = new Edit("searchValue","950","618","185","40",null,null,null,null,null,null,this);
            obj.set_taborder("6");
            this.addChild(obj.name, obj);

            obj = new Button("btn_search","1145","618","75","40",null,null,null,null,null,null,this);
            obj.set_taborder("7");
            obj.set_text("검색");
            obj.set_cssclass("notRadius");
            this.addChild(obj.name, obj);

            obj = new Static("Static00","60","30","120","60",null,null,null,null,null,null,this);
            obj.set_taborder("8");
            obj.set_text("사원 관리");
            obj.set_font("normal 700 17pt/normal \"Arial\"");
            this.addChild(obj.name, obj);
            // Layout Functions
            //-- Default Layout : this
            obj = new Layout("default","",1280,720,this,function(p){});
            obj.set_mobileorientation("landscape");
            obj.set_stepcount("0");
            this.addLayout(obj.name, obj);
            
            // BindItem Information

            
            // TriggerItem Information

        };
        
        this.loadPreloadList = function()
        {

        };
        
        // User Script
        this.registerScript("Form_MemberList.xfdl", function() {
        // 화면 실행 시 사원 리스트 불러오기
        this.Form_MemberList_onload = function(obj,e)
        {
        	this.transaction(
        			"member_list" // 1. ID
        			, "SW::admin/member/list.sw" // 2. URL
        			, "" // 3. InDs : F->S jsp(I, U, D)
        			, "ds_member=out_member" // 4. OutDs : S->F jsp(SELECT) - 스페이스는 구분자라서 = 옆에 스페이스 없이 써야 함
        			, "inVar=all" // 5. InVar : F->S(var)
        			, "fn_callback_tran" // 6. callback function(transaction 완료 시 호출되는 함수)
        		);
        };

        this.out_var = "";
        this.fn_callback_tran = function(id, nErrorCode, sErrorMsg)
        {
        	if(id=="member_list")
        	{
        		if(nErrorCode < 0)
        		{
        			this.alert("사원 조회 실패 : " + sErrorMsg);
        			return;
        		}
        	}else if(id=="member_list_search")
        	{
        		if(nErrorCode < 0)
        		{
        			this.alert("사원 검색 실패 : " + sErrorMsg);
        			return;
        		}
        	}
        }

        // 재직 버튼 클릭
        this.btn_exist_onclick = function(obj,e)
        {
        	this.transaction(
        			"member_list" // 1. ID
        			, "SW::admin/member/list.sw" // 2. URL
        			, "" // 3. InDs : F->S jsp(I, U, D)
        			, "ds_member=out_member" // 4. OutDs : S->F jsp(SELECT) - 스페이스는 구분자라서 = 옆에 스페이스 없이 써야 함
        			, "inVar=exist" // 5. InVar : F->S(var)
        			, "fn_callback_tran" // 6. callback function(transaction 완료 시 호출되는 함수)
        		);
        };

        // 퇴직 버튼 클릭
        this.btn_noExist_onclick = function(obj,e)
        {
        	this.transaction(
        			"member_list" // 1. ID
        			, "SW::admin/member/list.sw" // 2. URL
        			, "" // 3. InDs : F->S jsp(I, U, D)
        			, "ds_member=out_member" // 4. OutDs : S->F jsp(SELECT) - 스페이스는 구분자라서 = 옆에 스페이스 없이 써야 함
        			, "inVar=noExist" // 5. InVar : F->S(var)
        			, "fn_callback_tran" // 6. callback function(transaction 완료 시 호출되는 함수)
        		);
        };

        // 검색 버튼 클릭
        this.btn_search_onclick = function(obj,e)
        {
        	this.transaction(
        			"member_list_search" // 1. ID
        			, "SW::admin/member/searchList.sw" // 2. URL
        			, "" // 3. InDs : F->S jsp(I, U, D)
        			, "ds_member=out_member" // 4. OutDs : S->F jsp(SELECT) - 스페이스는 구분자라서 = 옆에 스페이스 없이 써야 함
        			, "searchCondition=" + this.searchCondition.value + " searchValue=" + nexacro.wrapQuote(this.searchValue.value) // 5. InVar : F->S(var)
        			, "fn_callback_tran" // 6. callback function(transaction 완료 시 호출되는 함수)
        		);
        };

        this.searchValue_onkeydown = function(obj,e)
        {
        	if(e.keycode == 13) { // 엔터키 누르면
        		this.btn_search_onclick(); // 검색 버튼 실행
        	}
        };

        // 더블 클릭 시 사원 정보로 이동
        this.Grid00_oncelldblclick = function(obj,e)
        {
        	var objApp = nexacro.getApplication();
        	objApp.setVariable("memberNum", obj.getCellText(e.row, 1));
        	this.go("FrameBase::Form_MemberModify.xfdl");
        };

        // 사원 등록 버튼
        this.Button00_onclick = function(obj,e)
        {
        	this.go("FrameBase::Form_MemberRegister.xfdl");
        };

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.addEventHandler("onload",this.Form_MemberList_onload,this);
            this.Grid00.addEventHandler("oncelldblclick",this.Grid00_oncelldblclick,this);
            this.Button00.addEventHandler("onclick",this.Button00_onclick,this);
            this.btn_all.addEventHandler("onclick",this.Form_MemberList_onload,this);
            this.btn_exist.addEventHandler("onclick",this.btn_exist_onclick,this);
            this.btn_noExist.addEventHandler("onclick",this.btn_noExist_onclick,this);
            this.searchValue.addEventHandler("onkeydown",this.searchValue_onkeydown,this);
            this.btn_search.addEventHandler("onclick",this.btn_search_onclick,this);
        };
        this.loadIncludeScript("Form_MemberList.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();

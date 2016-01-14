package org.salgar.swf_statemachine.xtext.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.salgar.swf_statemachine.xtext.services.StateMachineDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalStateMachineDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'package'", "'{'", "'}'", "'statemachine'", "'initialState'", "'control-object'", "'events'", "'states'", "'.'", "'state'", "'transition'", "'=>'", "'trigger'", "'guard'", "'action'", "'event'", "'attribute'", "'type'", "'='", "'NONE'", "'java.lang.Boolean'", "'java.lang.Integer'", "'java.lang.Long'", "'java.lang.Float'", "'java.lang.Decimal'", "'java.lang.String'", "'java.lang.Date'", "'java.lang.DateTime'", "'java.lang.Time'", "'java.util.List'"
    };
    public static final int RULE_ID=4;
    public static final int T__40=40;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int RULE_STRING=5;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__16=16;
    public static final int T__34=34;
    public static final int T__15=15;
    public static final int T__35=35;
    public static final int T__18=18;
    public static final int T__36=36;
    public static final int T__17=17;
    public static final int T__37=37;
    public static final int T__12=12;
    public static final int T__38=38;
    public static final int T__11=11;
    public static final int T__39=39;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalStateMachineDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalStateMachineDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalStateMachineDslParser.tokenNames; }
    public String getGrammarFileName() { return "InternalStateMachineDsl.g"; }



     	private StateMachineDslGrammarAccess grammarAccess;

        public InternalStateMachineDslParser(TokenStream input, StateMachineDslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected StateMachineDslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalStateMachineDsl.g:65:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalStateMachineDsl.g:65:46: (iv_ruleModel= ruleModel EOF )
            // InternalStateMachineDsl.g:66:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalStateMachineDsl.g:72:1: ruleModel returns [EObject current=null] : ( (lv_elements_0_0= ruleBase ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_0_0 = null;



        	enterRule();

        try {
            // InternalStateMachineDsl.g:78:2: ( ( (lv_elements_0_0= ruleBase ) )* )
            // InternalStateMachineDsl.g:79:2: ( (lv_elements_0_0= ruleBase ) )*
            {
            // InternalStateMachineDsl.g:79:2: ( (lv_elements_0_0= ruleBase ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11||LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalStateMachineDsl.g:80:3: (lv_elements_0_0= ruleBase )
            	    {
            	    // InternalStateMachineDsl.g:80:3: (lv_elements_0_0= ruleBase )
            	    // InternalStateMachineDsl.g:81:4: lv_elements_0_0= ruleBase
            	    {

            	    				newCompositeNode(grammarAccess.getModelAccess().getElementsBaseParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_3);
            	    lv_elements_0_0=ruleBase();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getModelRule());
            	    				}
            	    				add(
            	    					current,
            	    					"elements",
            	    					lv_elements_0_0,
            	    					"org.salgar.swf_statemachine.xtext.StateMachineDsl.Base");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRulePackageDeclaration"
    // InternalStateMachineDsl.g:101:1: entryRulePackageDeclaration returns [EObject current=null] : iv_rulePackageDeclaration= rulePackageDeclaration EOF ;
    public final EObject entryRulePackageDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageDeclaration = null;


        try {
            // InternalStateMachineDsl.g:101:59: (iv_rulePackageDeclaration= rulePackageDeclaration EOF )
            // InternalStateMachineDsl.g:102:2: iv_rulePackageDeclaration= rulePackageDeclaration EOF
            {
             newCompositeNode(grammarAccess.getPackageDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePackageDeclaration=rulePackageDeclaration();

            state._fsp--;

             current =iv_rulePackageDeclaration; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePackageDeclaration"


    // $ANTLR start "rulePackageDeclaration"
    // InternalStateMachineDsl.g:108:1: rulePackageDeclaration returns [EObject current=null] : (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleBase ) )* otherlv_4= '}' ) ;
    public final EObject rulePackageDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_elements_3_0 = null;



        	enterRule();

        try {
            // InternalStateMachineDsl.g:114:2: ( (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleBase ) )* otherlv_4= '}' ) )
            // InternalStateMachineDsl.g:115:2: (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleBase ) )* otherlv_4= '}' )
            {
            // InternalStateMachineDsl.g:115:2: (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleBase ) )* otherlv_4= '}' )
            // InternalStateMachineDsl.g:116:3: otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleBase ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getPackageDeclarationAccess().getPackageKeyword_0());
            		
            // InternalStateMachineDsl.g:120:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalStateMachineDsl.g:121:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalStateMachineDsl.g:121:4: (lv_name_1_0= ruleQualifiedName )
            // InternalStateMachineDsl.g:122:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getPackageDeclarationAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_5);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPackageDeclarationRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.salgar.swf_statemachine.xtext.StateMachineDsl.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getPackageDeclarationAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalStateMachineDsl.g:143:3: ( (lv_elements_3_0= ruleBase ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==11||LA2_0==14) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalStateMachineDsl.g:144:4: (lv_elements_3_0= ruleBase )
            	    {
            	    // InternalStateMachineDsl.g:144:4: (lv_elements_3_0= ruleBase )
            	    // InternalStateMachineDsl.g:145:5: lv_elements_3_0= ruleBase
            	    {

            	    					newCompositeNode(grammarAccess.getPackageDeclarationAccess().getElementsBaseParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_6);
            	    lv_elements_3_0=ruleBase();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getPackageDeclarationRule());
            	    					}
            	    					add(
            	    						current,
            	    						"elements",
            	    						lv_elements_3_0,
            	    						"org.salgar.swf_statemachine.xtext.StateMachineDsl.Base");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_4=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getPackageDeclarationAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePackageDeclaration"


    // $ANTLR start "entryRuleStateMachine"
    // InternalStateMachineDsl.g:170:1: entryRuleStateMachine returns [EObject current=null] : iv_ruleStateMachine= ruleStateMachine EOF ;
    public final EObject entryRuleStateMachine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateMachine = null;


        try {
            // InternalStateMachineDsl.g:170:53: (iv_ruleStateMachine= ruleStateMachine EOF )
            // InternalStateMachineDsl.g:171:2: iv_ruleStateMachine= ruleStateMachine EOF
            {
             newCompositeNode(grammarAccess.getStateMachineRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStateMachine=ruleStateMachine();

            state._fsp--;

             current =iv_ruleStateMachine; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStateMachine"


    // $ANTLR start "ruleStateMachine"
    // InternalStateMachineDsl.g:177:1: ruleStateMachine returns [EObject current=null] : (otherlv_0= 'statemachine' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'initialState' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'control-object' ( (lv_controlObject_5_0= ruleControlObject ) ) (otherlv_6= 'events' (otherlv_7= '{' ( (lv_events_8_0= ruleEvent ) )* otherlv_9= '}' ) ) (otherlv_10= 'states' (otherlv_11= '{' ( (lv_states_12_0= ruleState ) )* otherlv_13= '}' ) ) ) ;
    public final EObject ruleStateMachine() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_controlObject_5_0 = null;

        EObject lv_events_8_0 = null;

        EObject lv_states_12_0 = null;



        	enterRule();

        try {
            // InternalStateMachineDsl.g:183:2: ( (otherlv_0= 'statemachine' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'initialState' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'control-object' ( (lv_controlObject_5_0= ruleControlObject ) ) (otherlv_6= 'events' (otherlv_7= '{' ( (lv_events_8_0= ruleEvent ) )* otherlv_9= '}' ) ) (otherlv_10= 'states' (otherlv_11= '{' ( (lv_states_12_0= ruleState ) )* otherlv_13= '}' ) ) ) )
            // InternalStateMachineDsl.g:184:2: (otherlv_0= 'statemachine' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'initialState' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'control-object' ( (lv_controlObject_5_0= ruleControlObject ) ) (otherlv_6= 'events' (otherlv_7= '{' ( (lv_events_8_0= ruleEvent ) )* otherlv_9= '}' ) ) (otherlv_10= 'states' (otherlv_11= '{' ( (lv_states_12_0= ruleState ) )* otherlv_13= '}' ) ) )
            {
            // InternalStateMachineDsl.g:184:2: (otherlv_0= 'statemachine' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'initialState' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'control-object' ( (lv_controlObject_5_0= ruleControlObject ) ) (otherlv_6= 'events' (otherlv_7= '{' ( (lv_events_8_0= ruleEvent ) )* otherlv_9= '}' ) ) (otherlv_10= 'states' (otherlv_11= '{' ( (lv_states_12_0= ruleState ) )* otherlv_13= '}' ) ) )
            // InternalStateMachineDsl.g:185:3: otherlv_0= 'statemachine' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'initialState' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'control-object' ( (lv_controlObject_5_0= ruleControlObject ) ) (otherlv_6= 'events' (otherlv_7= '{' ( (lv_events_8_0= ruleEvent ) )* otherlv_9= '}' ) ) (otherlv_10= 'states' (otherlv_11= '{' ( (lv_states_12_0= ruleState ) )* otherlv_13= '}' ) )
            {
            otherlv_0=(Token)match(input,14,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getStateMachineAccess().getStatemachineKeyword_0());
            		
            // InternalStateMachineDsl.g:189:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalStateMachineDsl.g:190:4: (lv_name_1_0= RULE_ID )
            {
            // InternalStateMachineDsl.g:190:4: (lv_name_1_0= RULE_ID )
            // InternalStateMachineDsl.g:191:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_7); 

            					newLeafNode(lv_name_1_0, grammarAccess.getStateMachineAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStateMachineRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getStateMachineAccess().getInitialStateKeyword_2());
            		
            // InternalStateMachineDsl.g:211:3: ( (otherlv_3= RULE_ID ) )
            // InternalStateMachineDsl.g:212:4: (otherlv_3= RULE_ID )
            {
            // InternalStateMachineDsl.g:212:4: (otherlv_3= RULE_ID )
            // InternalStateMachineDsl.g:213:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStateMachineRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_8); 

            					newLeafNode(otherlv_3, grammarAccess.getStateMachineAccess().getInitialStateStateCrossReference_3_0());
            				

            }


            }

            otherlv_4=(Token)match(input,16,FOLLOW_5); 

            			newLeafNode(otherlv_4, grammarAccess.getStateMachineAccess().getControlObjectKeyword_4());
            		
            // InternalStateMachineDsl.g:228:3: ( (lv_controlObject_5_0= ruleControlObject ) )
            // InternalStateMachineDsl.g:229:4: (lv_controlObject_5_0= ruleControlObject )
            {
            // InternalStateMachineDsl.g:229:4: (lv_controlObject_5_0= ruleControlObject )
            // InternalStateMachineDsl.g:230:5: lv_controlObject_5_0= ruleControlObject
            {

            					newCompositeNode(grammarAccess.getStateMachineAccess().getControlObjectControlObjectParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_9);
            lv_controlObject_5_0=ruleControlObject();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStateMachineRule());
            					}
            					set(
            						current,
            						"controlObject",
            						lv_controlObject_5_0,
            						"org.salgar.swf_statemachine.xtext.StateMachineDsl.ControlObject");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalStateMachineDsl.g:247:3: (otherlv_6= 'events' (otherlv_7= '{' ( (lv_events_8_0= ruleEvent ) )* otherlv_9= '}' ) )
            // InternalStateMachineDsl.g:248:4: otherlv_6= 'events' (otherlv_7= '{' ( (lv_events_8_0= ruleEvent ) )* otherlv_9= '}' )
            {
            otherlv_6=(Token)match(input,17,FOLLOW_5); 

            				newLeafNode(otherlv_6, grammarAccess.getStateMachineAccess().getEventsKeyword_6_0());
            			
            // InternalStateMachineDsl.g:252:4: (otherlv_7= '{' ( (lv_events_8_0= ruleEvent ) )* otherlv_9= '}' )
            // InternalStateMachineDsl.g:253:5: otherlv_7= '{' ( (lv_events_8_0= ruleEvent ) )* otherlv_9= '}'
            {
            otherlv_7=(Token)match(input,12,FOLLOW_10); 

            					newLeafNode(otherlv_7, grammarAccess.getStateMachineAccess().getLeftCurlyBracketKeyword_6_1_0());
            				
            // InternalStateMachineDsl.g:257:5: ( (lv_events_8_0= ruleEvent ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==26) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalStateMachineDsl.g:258:6: (lv_events_8_0= ruleEvent )
            	    {
            	    // InternalStateMachineDsl.g:258:6: (lv_events_8_0= ruleEvent )
            	    // InternalStateMachineDsl.g:259:7: lv_events_8_0= ruleEvent
            	    {

            	    							newCompositeNode(grammarAccess.getStateMachineAccess().getEventsEventParserRuleCall_6_1_1_0());
            	    						
            	    pushFollow(FOLLOW_10);
            	    lv_events_8_0=ruleEvent();

            	    state._fsp--;


            	    							if (current==null) {
            	    								current = createModelElementForParent(grammarAccess.getStateMachineRule());
            	    							}
            	    							add(
            	    								current,
            	    								"events",
            	    								lv_events_8_0,
            	    								"org.salgar.swf_statemachine.xtext.StateMachineDsl.Event");
            	    							afterParserOrEnumRuleCall();
            	    						

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_9=(Token)match(input,13,FOLLOW_11); 

            					newLeafNode(otherlv_9, grammarAccess.getStateMachineAccess().getRightCurlyBracketKeyword_6_1_2());
            				

            }


            }

            // InternalStateMachineDsl.g:282:3: (otherlv_10= 'states' (otherlv_11= '{' ( (lv_states_12_0= ruleState ) )* otherlv_13= '}' ) )
            // InternalStateMachineDsl.g:283:4: otherlv_10= 'states' (otherlv_11= '{' ( (lv_states_12_0= ruleState ) )* otherlv_13= '}' )
            {
            otherlv_10=(Token)match(input,18,FOLLOW_5); 

            				newLeafNode(otherlv_10, grammarAccess.getStateMachineAccess().getStatesKeyword_7_0());
            			
            // InternalStateMachineDsl.g:287:4: (otherlv_11= '{' ( (lv_states_12_0= ruleState ) )* otherlv_13= '}' )
            // InternalStateMachineDsl.g:288:5: otherlv_11= '{' ( (lv_states_12_0= ruleState ) )* otherlv_13= '}'
            {
            otherlv_11=(Token)match(input,12,FOLLOW_12); 

            					newLeafNode(otherlv_11, grammarAccess.getStateMachineAccess().getLeftCurlyBracketKeyword_7_1_0());
            				
            // InternalStateMachineDsl.g:292:5: ( (lv_states_12_0= ruleState ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==20) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalStateMachineDsl.g:293:6: (lv_states_12_0= ruleState )
            	    {
            	    // InternalStateMachineDsl.g:293:6: (lv_states_12_0= ruleState )
            	    // InternalStateMachineDsl.g:294:7: lv_states_12_0= ruleState
            	    {

            	    							newCompositeNode(grammarAccess.getStateMachineAccess().getStatesStateParserRuleCall_7_1_1_0());
            	    						
            	    pushFollow(FOLLOW_12);
            	    lv_states_12_0=ruleState();

            	    state._fsp--;


            	    							if (current==null) {
            	    								current = createModelElementForParent(grammarAccess.getStateMachineRule());
            	    							}
            	    							add(
            	    								current,
            	    								"states",
            	    								lv_states_12_0,
            	    								"org.salgar.swf_statemachine.xtext.StateMachineDsl.State");
            	    							afterParserOrEnumRuleCall();
            	    						

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_13=(Token)match(input,13,FOLLOW_2); 

            					newLeafNode(otherlv_13, grammarAccess.getStateMachineAccess().getRightCurlyBracketKeyword_7_1_2());
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStateMachine"


    // $ANTLR start "entryRuleBase"
    // InternalStateMachineDsl.g:321:1: entryRuleBase returns [EObject current=null] : iv_ruleBase= ruleBase EOF ;
    public final EObject entryRuleBase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBase = null;


        try {
            // InternalStateMachineDsl.g:321:45: (iv_ruleBase= ruleBase EOF )
            // InternalStateMachineDsl.g:322:2: iv_ruleBase= ruleBase EOF
            {
             newCompositeNode(grammarAccess.getBaseRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBase=ruleBase();

            state._fsp--;

             current =iv_ruleBase; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBase"


    // $ANTLR start "ruleBase"
    // InternalStateMachineDsl.g:328:1: ruleBase returns [EObject current=null] : (this_PackageDeclaration_0= rulePackageDeclaration | this_StateMachine_1= ruleStateMachine ) ;
    public final EObject ruleBase() throws RecognitionException {
        EObject current = null;

        EObject this_PackageDeclaration_0 = null;

        EObject this_StateMachine_1 = null;



        	enterRule();

        try {
            // InternalStateMachineDsl.g:334:2: ( (this_PackageDeclaration_0= rulePackageDeclaration | this_StateMachine_1= ruleStateMachine ) )
            // InternalStateMachineDsl.g:335:2: (this_PackageDeclaration_0= rulePackageDeclaration | this_StateMachine_1= ruleStateMachine )
            {
            // InternalStateMachineDsl.g:335:2: (this_PackageDeclaration_0= rulePackageDeclaration | this_StateMachine_1= ruleStateMachine )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==11) ) {
                alt5=1;
            }
            else if ( (LA5_0==14) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalStateMachineDsl.g:336:3: this_PackageDeclaration_0= rulePackageDeclaration
                    {

                    			newCompositeNode(grammarAccess.getBaseAccess().getPackageDeclarationParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_PackageDeclaration_0=rulePackageDeclaration();

                    state._fsp--;


                    			current = this_PackageDeclaration_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalStateMachineDsl.g:345:3: this_StateMachine_1= ruleStateMachine
                    {

                    			newCompositeNode(grammarAccess.getBaseAccess().getStateMachineParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_StateMachine_1=ruleStateMachine();

                    state._fsp--;


                    			current = this_StateMachine_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBase"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalStateMachineDsl.g:357:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalStateMachineDsl.g:357:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalStateMachineDsl.g:358:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalStateMachineDsl.g:364:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalStateMachineDsl.g:370:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalStateMachineDsl.g:371:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalStateMachineDsl.g:371:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalStateMachineDsl.g:372:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_13); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalStateMachineDsl.g:379:3: (kw= '.' this_ID_2= RULE_ID )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==19) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalStateMachineDsl.g:380:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,19,FOLLOW_4); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_13); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleState"
    // InternalStateMachineDsl.g:397:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // InternalStateMachineDsl.g:397:46: (iv_ruleState= ruleState EOF )
            // InternalStateMachineDsl.g:398:2: iv_ruleState= ruleState EOF
            {
             newCompositeNode(grammarAccess.getStateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleState=ruleState();

            state._fsp--;

             current =iv_ruleState; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleState"


    // $ANTLR start "ruleState"
    // InternalStateMachineDsl.g:404:1: ruleState returns [EObject current=null] : (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_transitions_3_0= ruleTransition ) )* otherlv_4= '}' ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_transitions_3_0 = null;



        	enterRule();

        try {
            // InternalStateMachineDsl.g:410:2: ( (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_transitions_3_0= ruleTransition ) )* otherlv_4= '}' ) )
            // InternalStateMachineDsl.g:411:2: (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_transitions_3_0= ruleTransition ) )* otherlv_4= '}' )
            {
            // InternalStateMachineDsl.g:411:2: (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_transitions_3_0= ruleTransition ) )* otherlv_4= '}' )
            // InternalStateMachineDsl.g:412:3: otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_transitions_3_0= ruleTransition ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,20,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getStateAccess().getStateKeyword_0());
            		
            // InternalStateMachineDsl.g:416:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalStateMachineDsl.g:417:4: (lv_name_1_0= RULE_ID )
            {
            // InternalStateMachineDsl.g:417:4: (lv_name_1_0= RULE_ID )
            // InternalStateMachineDsl.g:418:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getStateAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStateRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getStateAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalStateMachineDsl.g:438:3: ( (lv_transitions_3_0= ruleTransition ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==21) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalStateMachineDsl.g:439:4: (lv_transitions_3_0= ruleTransition )
            	    {
            	    // InternalStateMachineDsl.g:439:4: (lv_transitions_3_0= ruleTransition )
            	    // InternalStateMachineDsl.g:440:5: lv_transitions_3_0= ruleTransition
            	    {

            	    					newCompositeNode(grammarAccess.getStateAccess().getTransitionsTransitionParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_14);
            	    lv_transitions_3_0=ruleTransition();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getStateRule());
            	    					}
            	    					add(
            	    						current,
            	    						"transitions",
            	    						lv_transitions_3_0,
            	    						"org.salgar.swf_statemachine.xtext.StateMachineDsl.Transition");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_4=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getStateAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleState"


    // $ANTLR start "entryRuleTransition"
    // InternalStateMachineDsl.g:465:1: entryRuleTransition returns [EObject current=null] : iv_ruleTransition= ruleTransition EOF ;
    public final EObject entryRuleTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransition = null;


        try {
            // InternalStateMachineDsl.g:465:51: (iv_ruleTransition= ruleTransition EOF )
            // InternalStateMachineDsl.g:466:2: iv_ruleTransition= ruleTransition EOF
            {
             newCompositeNode(grammarAccess.getTransitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTransition=ruleTransition();

            state._fsp--;

             current =iv_ruleTransition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTransition"


    // $ANTLR start "ruleTransition"
    // InternalStateMachineDsl.g:472:1: ruleTransition returns [EObject current=null] : (otherlv_0= 'transition' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=>' ( (otherlv_3= RULE_ID ) ) otherlv_4= '{' (otherlv_5= 'trigger' otherlv_6= '{' ( (otherlv_7= RULE_ID ) ) otherlv_8= '}' ) (otherlv_9= 'guard' otherlv_10= '{' ( (lv_guard_11_0= ruleGuard ) ) otherlv_12= '}' )? (otherlv_13= 'action' otherlv_14= '{' ( (lv_action_15_0= ruleAction ) ) otherlv_16= '}' )? otherlv_17= '}' ) ;
    public final EObject ruleTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        EObject lv_guard_11_0 = null;

        EObject lv_action_15_0 = null;



        	enterRule();

        try {
            // InternalStateMachineDsl.g:478:2: ( (otherlv_0= 'transition' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=>' ( (otherlv_3= RULE_ID ) ) otherlv_4= '{' (otherlv_5= 'trigger' otherlv_6= '{' ( (otherlv_7= RULE_ID ) ) otherlv_8= '}' ) (otherlv_9= 'guard' otherlv_10= '{' ( (lv_guard_11_0= ruleGuard ) ) otherlv_12= '}' )? (otherlv_13= 'action' otherlv_14= '{' ( (lv_action_15_0= ruleAction ) ) otherlv_16= '}' )? otherlv_17= '}' ) )
            // InternalStateMachineDsl.g:479:2: (otherlv_0= 'transition' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=>' ( (otherlv_3= RULE_ID ) ) otherlv_4= '{' (otherlv_5= 'trigger' otherlv_6= '{' ( (otherlv_7= RULE_ID ) ) otherlv_8= '}' ) (otherlv_9= 'guard' otherlv_10= '{' ( (lv_guard_11_0= ruleGuard ) ) otherlv_12= '}' )? (otherlv_13= 'action' otherlv_14= '{' ( (lv_action_15_0= ruleAction ) ) otherlv_16= '}' )? otherlv_17= '}' )
            {
            // InternalStateMachineDsl.g:479:2: (otherlv_0= 'transition' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=>' ( (otherlv_3= RULE_ID ) ) otherlv_4= '{' (otherlv_5= 'trigger' otherlv_6= '{' ( (otherlv_7= RULE_ID ) ) otherlv_8= '}' ) (otherlv_9= 'guard' otherlv_10= '{' ( (lv_guard_11_0= ruleGuard ) ) otherlv_12= '}' )? (otherlv_13= 'action' otherlv_14= '{' ( (lv_action_15_0= ruleAction ) ) otherlv_16= '}' )? otherlv_17= '}' )
            // InternalStateMachineDsl.g:480:3: otherlv_0= 'transition' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=>' ( (otherlv_3= RULE_ID ) ) otherlv_4= '{' (otherlv_5= 'trigger' otherlv_6= '{' ( (otherlv_7= RULE_ID ) ) otherlv_8= '}' ) (otherlv_9= 'guard' otherlv_10= '{' ( (lv_guard_11_0= ruleGuard ) ) otherlv_12= '}' )? (otherlv_13= 'action' otherlv_14= '{' ( (lv_action_15_0= ruleAction ) ) otherlv_16= '}' )? otherlv_17= '}'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getTransitionAccess().getTransitionKeyword_0());
            		
            // InternalStateMachineDsl.g:484:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalStateMachineDsl.g:485:4: (lv_name_1_0= RULE_ID )
            {
            // InternalStateMachineDsl.g:485:4: (lv_name_1_0= RULE_ID )
            // InternalStateMachineDsl.g:486:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_15); 

            					newLeafNode(lv_name_1_0, grammarAccess.getTransitionAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTransitionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,22,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getTransitionAccess().getEqualsSignGreaterThanSignKeyword_2());
            		
            // InternalStateMachineDsl.g:506:3: ( (otherlv_3= RULE_ID ) )
            // InternalStateMachineDsl.g:507:4: (otherlv_3= RULE_ID )
            {
            // InternalStateMachineDsl.g:507:4: (otherlv_3= RULE_ID )
            // InternalStateMachineDsl.g:508:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTransitionRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(otherlv_3, grammarAccess.getTransitionAccess().getTargetStateCrossReference_3_0());
            				

            }


            }

            otherlv_4=(Token)match(input,12,FOLLOW_16); 

            			newLeafNode(otherlv_4, grammarAccess.getTransitionAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalStateMachineDsl.g:523:3: (otherlv_5= 'trigger' otherlv_6= '{' ( (otherlv_7= RULE_ID ) ) otherlv_8= '}' )
            // InternalStateMachineDsl.g:524:4: otherlv_5= 'trigger' otherlv_6= '{' ( (otherlv_7= RULE_ID ) ) otherlv_8= '}'
            {
            otherlv_5=(Token)match(input,23,FOLLOW_5); 

            				newLeafNode(otherlv_5, grammarAccess.getTransitionAccess().getTriggerKeyword_5_0());
            			
            otherlv_6=(Token)match(input,12,FOLLOW_4); 

            				newLeafNode(otherlv_6, grammarAccess.getTransitionAccess().getLeftCurlyBracketKeyword_5_1());
            			
            // InternalStateMachineDsl.g:532:4: ( (otherlv_7= RULE_ID ) )
            // InternalStateMachineDsl.g:533:5: (otherlv_7= RULE_ID )
            {
            // InternalStateMachineDsl.g:533:5: (otherlv_7= RULE_ID )
            // InternalStateMachineDsl.g:534:6: otherlv_7= RULE_ID
            {

            						if (current==null) {
            							current = createModelElement(grammarAccess.getTransitionRule());
            						}
            					
            otherlv_7=(Token)match(input,RULE_ID,FOLLOW_17); 

            						newLeafNode(otherlv_7, grammarAccess.getTransitionAccess().getTriggerEventCrossReference_5_2_0());
            					

            }


            }

            otherlv_8=(Token)match(input,13,FOLLOW_18); 

            				newLeafNode(otherlv_8, grammarAccess.getTransitionAccess().getRightCurlyBracketKeyword_5_3());
            			

            }

            // InternalStateMachineDsl.g:550:3: (otherlv_9= 'guard' otherlv_10= '{' ( (lv_guard_11_0= ruleGuard ) ) otherlv_12= '}' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==24) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalStateMachineDsl.g:551:4: otherlv_9= 'guard' otherlv_10= '{' ( (lv_guard_11_0= ruleGuard ) ) otherlv_12= '}'
                    {
                    otherlv_9=(Token)match(input,24,FOLLOW_5); 

                    				newLeafNode(otherlv_9, grammarAccess.getTransitionAccess().getGuardKeyword_6_0());
                    			
                    otherlv_10=(Token)match(input,12,FOLLOW_4); 

                    				newLeafNode(otherlv_10, grammarAccess.getTransitionAccess().getLeftCurlyBracketKeyword_6_1());
                    			
                    // InternalStateMachineDsl.g:559:4: ( (lv_guard_11_0= ruleGuard ) )
                    // InternalStateMachineDsl.g:560:5: (lv_guard_11_0= ruleGuard )
                    {
                    // InternalStateMachineDsl.g:560:5: (lv_guard_11_0= ruleGuard )
                    // InternalStateMachineDsl.g:561:6: lv_guard_11_0= ruleGuard
                    {

                    						newCompositeNode(grammarAccess.getTransitionAccess().getGuardGuardParserRuleCall_6_2_0());
                    					
                    pushFollow(FOLLOW_17);
                    lv_guard_11_0=ruleGuard();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTransitionRule());
                    						}
                    						set(
                    							current,
                    							"guard",
                    							lv_guard_11_0,
                    							"org.salgar.swf_statemachine.xtext.StateMachineDsl.Guard");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_12=(Token)match(input,13,FOLLOW_19); 

                    				newLeafNode(otherlv_12, grammarAccess.getTransitionAccess().getRightCurlyBracketKeyword_6_3());
                    			

                    }
                    break;

            }

            // InternalStateMachineDsl.g:583:3: (otherlv_13= 'action' otherlv_14= '{' ( (lv_action_15_0= ruleAction ) ) otherlv_16= '}' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==25) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalStateMachineDsl.g:584:4: otherlv_13= 'action' otherlv_14= '{' ( (lv_action_15_0= ruleAction ) ) otherlv_16= '}'
                    {
                    otherlv_13=(Token)match(input,25,FOLLOW_5); 

                    				newLeafNode(otherlv_13, grammarAccess.getTransitionAccess().getActionKeyword_7_0());
                    			
                    otherlv_14=(Token)match(input,12,FOLLOW_4); 

                    				newLeafNode(otherlv_14, grammarAccess.getTransitionAccess().getLeftCurlyBracketKeyword_7_1());
                    			
                    // InternalStateMachineDsl.g:592:4: ( (lv_action_15_0= ruleAction ) )
                    // InternalStateMachineDsl.g:593:5: (lv_action_15_0= ruleAction )
                    {
                    // InternalStateMachineDsl.g:593:5: (lv_action_15_0= ruleAction )
                    // InternalStateMachineDsl.g:594:6: lv_action_15_0= ruleAction
                    {

                    						newCompositeNode(grammarAccess.getTransitionAccess().getActionActionParserRuleCall_7_2_0());
                    					
                    pushFollow(FOLLOW_17);
                    lv_action_15_0=ruleAction();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTransitionRule());
                    						}
                    						set(
                    							current,
                    							"action",
                    							lv_action_15_0,
                    							"org.salgar.swf_statemachine.xtext.StateMachineDsl.Action");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_16=(Token)match(input,13,FOLLOW_17); 

                    				newLeafNode(otherlv_16, grammarAccess.getTransitionAccess().getRightCurlyBracketKeyword_7_3());
                    			

                    }
                    break;

            }

            otherlv_17=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_17, grammarAccess.getTransitionAccess().getRightCurlyBracketKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTransition"


    // $ANTLR start "entryRuleEvent"
    // InternalStateMachineDsl.g:624:1: entryRuleEvent returns [EObject current=null] : iv_ruleEvent= ruleEvent EOF ;
    public final EObject entryRuleEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvent = null;


        try {
            // InternalStateMachineDsl.g:624:46: (iv_ruleEvent= ruleEvent EOF )
            // InternalStateMachineDsl.g:625:2: iv_ruleEvent= ruleEvent EOF
            {
             newCompositeNode(grammarAccess.getEventRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEvent=ruleEvent();

            state._fsp--;

             current =iv_ruleEvent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEvent"


    // $ANTLR start "ruleEvent"
    // InternalStateMachineDsl.g:631:1: ruleEvent returns [EObject current=null] : (otherlv_0= 'event' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleEvent() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalStateMachineDsl.g:637:2: ( (otherlv_0= 'event' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalStateMachineDsl.g:638:2: (otherlv_0= 'event' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalStateMachineDsl.g:638:2: (otherlv_0= 'event' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalStateMachineDsl.g:639:3: otherlv_0= 'event' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,26,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getEventAccess().getEventKeyword_0());
            		
            // InternalStateMachineDsl.g:643:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalStateMachineDsl.g:644:4: (lv_name_1_0= RULE_ID )
            {
            // InternalStateMachineDsl.g:644:4: (lv_name_1_0= RULE_ID )
            // InternalStateMachineDsl.g:645:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getEventAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEventRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEvent"


    // $ANTLR start "entryRuleGuard"
    // InternalStateMachineDsl.g:665:1: entryRuleGuard returns [EObject current=null] : iv_ruleGuard= ruleGuard EOF ;
    public final EObject entryRuleGuard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuard = null;


        try {
            // InternalStateMachineDsl.g:665:46: (iv_ruleGuard= ruleGuard EOF )
            // InternalStateMachineDsl.g:666:2: iv_ruleGuard= ruleGuard EOF
            {
             newCompositeNode(grammarAccess.getGuardRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGuard=ruleGuard();

            state._fsp--;

             current =iv_ruleGuard; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGuard"


    // $ANTLR start "ruleGuard"
    // InternalStateMachineDsl.g:672:1: ruleGuard returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleGuard() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalStateMachineDsl.g:678:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalStateMachineDsl.g:679:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalStateMachineDsl.g:679:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // InternalStateMachineDsl.g:680:3: () ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalStateMachineDsl.g:680:3: ()
            // InternalStateMachineDsl.g:681:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getGuardAccess().getGuardAction_0(),
            					current);
            			

            }

            // InternalStateMachineDsl.g:687:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalStateMachineDsl.g:688:4: (lv_name_1_0= RULE_ID )
            {
            // InternalStateMachineDsl.g:688:4: (lv_name_1_0= RULE_ID )
            // InternalStateMachineDsl.g:689:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getGuardAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGuardRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGuard"


    // $ANTLR start "entryRuleAction"
    // InternalStateMachineDsl.g:709:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // InternalStateMachineDsl.g:709:47: (iv_ruleAction= ruleAction EOF )
            // InternalStateMachineDsl.g:710:2: iv_ruleAction= ruleAction EOF
            {
             newCompositeNode(grammarAccess.getActionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAction=ruleAction();

            state._fsp--;

             current =iv_ruleAction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAction"


    // $ANTLR start "ruleAction"
    // InternalStateMachineDsl.g:716:1: ruleAction returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalStateMachineDsl.g:722:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalStateMachineDsl.g:723:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalStateMachineDsl.g:723:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // InternalStateMachineDsl.g:724:3: () ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalStateMachineDsl.g:724:3: ()
            // InternalStateMachineDsl.g:725:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getActionAccess().getActionAction_0(),
            					current);
            			

            }

            // InternalStateMachineDsl.g:731:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalStateMachineDsl.g:732:4: (lv_name_1_0= RULE_ID )
            {
            // InternalStateMachineDsl.g:732:4: (lv_name_1_0= RULE_ID )
            // InternalStateMachineDsl.g:733:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getActionAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAction"


    // $ANTLR start "entryRuleControlObject"
    // InternalStateMachineDsl.g:753:1: entryRuleControlObject returns [EObject current=null] : iv_ruleControlObject= ruleControlObject EOF ;
    public final EObject entryRuleControlObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleControlObject = null;


        try {
            // InternalStateMachineDsl.g:753:54: (iv_ruleControlObject= ruleControlObject EOF )
            // InternalStateMachineDsl.g:754:2: iv_ruleControlObject= ruleControlObject EOF
            {
             newCompositeNode(grammarAccess.getControlObjectRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleControlObject=ruleControlObject();

            state._fsp--;

             current =iv_ruleControlObject; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleControlObject"


    // $ANTLR start "ruleControlObject"
    // InternalStateMachineDsl.g:760:1: ruleControlObject returns [EObject current=null] : (otherlv_0= '{' ( (lv_attributes_1_0= ruleControlObjectAttribute ) )* otherlv_2= '}' ) ;
    public final EObject ruleControlObject() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_attributes_1_0 = null;



        	enterRule();

        try {
            // InternalStateMachineDsl.g:766:2: ( (otherlv_0= '{' ( (lv_attributes_1_0= ruleControlObjectAttribute ) )* otherlv_2= '}' ) )
            // InternalStateMachineDsl.g:767:2: (otherlv_0= '{' ( (lv_attributes_1_0= ruleControlObjectAttribute ) )* otherlv_2= '}' )
            {
            // InternalStateMachineDsl.g:767:2: (otherlv_0= '{' ( (lv_attributes_1_0= ruleControlObjectAttribute ) )* otherlv_2= '}' )
            // InternalStateMachineDsl.g:768:3: otherlv_0= '{' ( (lv_attributes_1_0= ruleControlObjectAttribute ) )* otherlv_2= '}'
            {
            otherlv_0=(Token)match(input,12,FOLLOW_20); 

            			newLeafNode(otherlv_0, grammarAccess.getControlObjectAccess().getLeftCurlyBracketKeyword_0());
            		
            // InternalStateMachineDsl.g:772:3: ( (lv_attributes_1_0= ruleControlObjectAttribute ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==27) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalStateMachineDsl.g:773:4: (lv_attributes_1_0= ruleControlObjectAttribute )
            	    {
            	    // InternalStateMachineDsl.g:773:4: (lv_attributes_1_0= ruleControlObjectAttribute )
            	    // InternalStateMachineDsl.g:774:5: lv_attributes_1_0= ruleControlObjectAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getControlObjectAccess().getAttributesControlObjectAttributeParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_20);
            	    lv_attributes_1_0=ruleControlObjectAttribute();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getControlObjectRule());
            	    					}
            	    					add(
            	    						current,
            	    						"attributes",
            	    						lv_attributes_1_0,
            	    						"org.salgar.swf_statemachine.xtext.StateMachineDsl.ControlObjectAttribute");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            otherlv_2=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getControlObjectAccess().getRightCurlyBracketKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleControlObject"


    // $ANTLR start "entryRuleControlObjectAttribute"
    // InternalStateMachineDsl.g:799:1: entryRuleControlObjectAttribute returns [EObject current=null] : iv_ruleControlObjectAttribute= ruleControlObjectAttribute EOF ;
    public final EObject entryRuleControlObjectAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleControlObjectAttribute = null;


        try {
            // InternalStateMachineDsl.g:799:63: (iv_ruleControlObjectAttribute= ruleControlObjectAttribute EOF )
            // InternalStateMachineDsl.g:800:2: iv_ruleControlObjectAttribute= ruleControlObjectAttribute EOF
            {
             newCompositeNode(grammarAccess.getControlObjectAttributeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleControlObjectAttribute=ruleControlObjectAttribute();

            state._fsp--;

             current =iv_ruleControlObjectAttribute; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleControlObjectAttribute"


    // $ANTLR start "ruleControlObjectAttribute"
    // InternalStateMachineDsl.g:806:1: ruleControlObjectAttribute returns [EObject current=null] : (otherlv_0= 'attribute' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'type' otherlv_3= '=' ( (lv_type_4_0= ruleAttributeBase ) ) ) ) ;
    public final EObject ruleControlObjectAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_type_4_0 = null;



        	enterRule();

        try {
            // InternalStateMachineDsl.g:812:2: ( (otherlv_0= 'attribute' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'type' otherlv_3= '=' ( (lv_type_4_0= ruleAttributeBase ) ) ) ) )
            // InternalStateMachineDsl.g:813:2: (otherlv_0= 'attribute' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'type' otherlv_3= '=' ( (lv_type_4_0= ruleAttributeBase ) ) ) )
            {
            // InternalStateMachineDsl.g:813:2: (otherlv_0= 'attribute' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'type' otherlv_3= '=' ( (lv_type_4_0= ruleAttributeBase ) ) ) )
            // InternalStateMachineDsl.g:814:3: otherlv_0= 'attribute' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'type' otherlv_3= '=' ( (lv_type_4_0= ruleAttributeBase ) ) )
            {
            otherlv_0=(Token)match(input,27,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getControlObjectAttributeAccess().getAttributeKeyword_0());
            		
            // InternalStateMachineDsl.g:818:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalStateMachineDsl.g:819:4: (lv_name_1_0= RULE_ID )
            {
            // InternalStateMachineDsl.g:819:4: (lv_name_1_0= RULE_ID )
            // InternalStateMachineDsl.g:820:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_21); 

            					newLeafNode(lv_name_1_0, grammarAccess.getControlObjectAttributeAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getControlObjectAttributeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalStateMachineDsl.g:836:3: (otherlv_2= 'type' otherlv_3= '=' ( (lv_type_4_0= ruleAttributeBase ) ) )
            // InternalStateMachineDsl.g:837:4: otherlv_2= 'type' otherlv_3= '=' ( (lv_type_4_0= ruleAttributeBase ) )
            {
            otherlv_2=(Token)match(input,28,FOLLOW_22); 

            				newLeafNode(otherlv_2, grammarAccess.getControlObjectAttributeAccess().getTypeKeyword_2_0());
            			
            otherlv_3=(Token)match(input,29,FOLLOW_23); 

            				newLeafNode(otherlv_3, grammarAccess.getControlObjectAttributeAccess().getEqualsSignKeyword_2_1());
            			
            // InternalStateMachineDsl.g:845:4: ( (lv_type_4_0= ruleAttributeBase ) )
            // InternalStateMachineDsl.g:846:5: (lv_type_4_0= ruleAttributeBase )
            {
            // InternalStateMachineDsl.g:846:5: (lv_type_4_0= ruleAttributeBase )
            // InternalStateMachineDsl.g:847:6: lv_type_4_0= ruleAttributeBase
            {

            						newCompositeNode(grammarAccess.getControlObjectAttributeAccess().getTypeAttributeBaseParserRuleCall_2_2_0());
            					
            pushFollow(FOLLOW_2);
            lv_type_4_0=ruleAttributeBase();

            state._fsp--;


            						if (current==null) {
            							current = createModelElementForParent(grammarAccess.getControlObjectAttributeRule());
            						}
            						set(
            							current,
            							"type",
            							lv_type_4_0,
            							"org.salgar.swf_statemachine.xtext.StateMachineDsl.AttributeBase");
            						afterParserOrEnumRuleCall();
            					

            }


            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleControlObjectAttribute"


    // $ANTLR start "entryRuleAttributeBase"
    // InternalStateMachineDsl.g:869:1: entryRuleAttributeBase returns [EObject current=null] : iv_ruleAttributeBase= ruleAttributeBase EOF ;
    public final EObject entryRuleAttributeBase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeBase = null;


        try {
            // InternalStateMachineDsl.g:869:54: (iv_ruleAttributeBase= ruleAttributeBase EOF )
            // InternalStateMachineDsl.g:870:2: iv_ruleAttributeBase= ruleAttributeBase EOF
            {
             newCompositeNode(grammarAccess.getAttributeBaseRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttributeBase=ruleAttributeBase();

            state._fsp--;

             current =iv_ruleAttributeBase; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttributeBase"


    // $ANTLR start "ruleAttributeBase"
    // InternalStateMachineDsl.g:876:1: ruleAttributeBase returns [EObject current=null] : (this_ObjectType_0= ruleObjectType | this_SimpleType_1= ruleSimpleType ) ;
    public final EObject ruleAttributeBase() throws RecognitionException {
        EObject current = null;

        EObject this_ObjectType_0 = null;

        EObject this_SimpleType_1 = null;



        	enterRule();

        try {
            // InternalStateMachineDsl.g:882:2: ( (this_ObjectType_0= ruleObjectType | this_SimpleType_1= ruleSimpleType ) )
            // InternalStateMachineDsl.g:883:2: (this_ObjectType_0= ruleObjectType | this_SimpleType_1= ruleSimpleType )
            {
            // InternalStateMachineDsl.g:883:2: (this_ObjectType_0= ruleObjectType | this_SimpleType_1= ruleSimpleType )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_STRING) ) {
                alt11=1;
            }
            else if ( ((LA11_0>=30 && LA11_0<=40)) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalStateMachineDsl.g:884:3: this_ObjectType_0= ruleObjectType
                    {

                    			newCompositeNode(grammarAccess.getAttributeBaseAccess().getObjectTypeParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ObjectType_0=ruleObjectType();

                    state._fsp--;


                    			current = this_ObjectType_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalStateMachineDsl.g:893:3: this_SimpleType_1= ruleSimpleType
                    {

                    			newCompositeNode(grammarAccess.getAttributeBaseAccess().getSimpleTypeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_SimpleType_1=ruleSimpleType();

                    state._fsp--;


                    			current = this_SimpleType_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttributeBase"


    // $ANTLR start "entryRuleSimpleType"
    // InternalStateMachineDsl.g:905:1: entryRuleSimpleType returns [EObject current=null] : iv_ruleSimpleType= ruleSimpleType EOF ;
    public final EObject entryRuleSimpleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleType = null;


        try {
            // InternalStateMachineDsl.g:905:51: (iv_ruleSimpleType= ruleSimpleType EOF )
            // InternalStateMachineDsl.g:906:2: iv_ruleSimpleType= ruleSimpleType EOF
            {
             newCompositeNode(grammarAccess.getSimpleTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSimpleType=ruleSimpleType();

            state._fsp--;

             current =iv_ruleSimpleType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSimpleType"


    // $ANTLR start "ruleSimpleType"
    // InternalStateMachineDsl.g:912:1: ruleSimpleType returns [EObject current=null] : ( (lv_type_0_0= ruleInternalType ) ) ;
    public final EObject ruleSimpleType() throws RecognitionException {
        EObject current = null;

        Enumerator lv_type_0_0 = null;



        	enterRule();

        try {
            // InternalStateMachineDsl.g:918:2: ( ( (lv_type_0_0= ruleInternalType ) ) )
            // InternalStateMachineDsl.g:919:2: ( (lv_type_0_0= ruleInternalType ) )
            {
            // InternalStateMachineDsl.g:919:2: ( (lv_type_0_0= ruleInternalType ) )
            // InternalStateMachineDsl.g:920:3: (lv_type_0_0= ruleInternalType )
            {
            // InternalStateMachineDsl.g:920:3: (lv_type_0_0= ruleInternalType )
            // InternalStateMachineDsl.g:921:4: lv_type_0_0= ruleInternalType
            {

            				newCompositeNode(grammarAccess.getSimpleTypeAccess().getTypeInternalTypeEnumRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_type_0_0=ruleInternalType();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getSimpleTypeRule());
            				}
            				set(
            					current,
            					"type",
            					lv_type_0_0,
            					"org.salgar.swf_statemachine.xtext.StateMachineDsl.InternalType");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSimpleType"


    // $ANTLR start "entryRuleObjectType"
    // InternalStateMachineDsl.g:941:1: entryRuleObjectType returns [EObject current=null] : iv_ruleObjectType= ruleObjectType EOF ;
    public final EObject entryRuleObjectType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectType = null;


        try {
            // InternalStateMachineDsl.g:941:51: (iv_ruleObjectType= ruleObjectType EOF )
            // InternalStateMachineDsl.g:942:2: iv_ruleObjectType= ruleObjectType EOF
            {
             newCompositeNode(grammarAccess.getObjectTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleObjectType=ruleObjectType();

            state._fsp--;

             current =iv_ruleObjectType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleObjectType"


    // $ANTLR start "ruleObjectType"
    // InternalStateMachineDsl.g:948:1: ruleObjectType returns [EObject current=null] : ( (lv_type_0_0= RULE_STRING ) ) ;
    public final EObject ruleObjectType() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_0=null;


        	enterRule();

        try {
            // InternalStateMachineDsl.g:954:2: ( ( (lv_type_0_0= RULE_STRING ) ) )
            // InternalStateMachineDsl.g:955:2: ( (lv_type_0_0= RULE_STRING ) )
            {
            // InternalStateMachineDsl.g:955:2: ( (lv_type_0_0= RULE_STRING ) )
            // InternalStateMachineDsl.g:956:3: (lv_type_0_0= RULE_STRING )
            {
            // InternalStateMachineDsl.g:956:3: (lv_type_0_0= RULE_STRING )
            // InternalStateMachineDsl.g:957:4: lv_type_0_0= RULE_STRING
            {
            lv_type_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            				newLeafNode(lv_type_0_0, grammarAccess.getObjectTypeAccess().getTypeSTRINGTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getObjectTypeRule());
            				}
            				setWithLastConsumed(
            					current,
            					"type",
            					lv_type_0_0,
            					"org.eclipse.xtext.common.Terminals.STRING");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleObjectType"


    // $ANTLR start "ruleInternalType"
    // InternalStateMachineDsl.g:976:1: ruleInternalType returns [Enumerator current=null] : ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'java.lang.Boolean' ) | (enumLiteral_2= 'java.lang.Integer' ) | (enumLiteral_3= 'java.lang.Long' ) | (enumLiteral_4= 'java.lang.Float' ) | (enumLiteral_5= 'java.lang.Decimal' ) | (enumLiteral_6= 'java.lang.String' ) | (enumLiteral_7= 'java.lang.Date' ) | (enumLiteral_8= 'java.lang.DateTime' ) | (enumLiteral_9= 'java.lang.Time' ) | (enumLiteral_10= 'java.util.List' ) ) ;
    public final Enumerator ruleInternalType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;
        Token enumLiteral_10=null;


        	enterRule();

        try {
            // InternalStateMachineDsl.g:982:2: ( ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'java.lang.Boolean' ) | (enumLiteral_2= 'java.lang.Integer' ) | (enumLiteral_3= 'java.lang.Long' ) | (enumLiteral_4= 'java.lang.Float' ) | (enumLiteral_5= 'java.lang.Decimal' ) | (enumLiteral_6= 'java.lang.String' ) | (enumLiteral_7= 'java.lang.Date' ) | (enumLiteral_8= 'java.lang.DateTime' ) | (enumLiteral_9= 'java.lang.Time' ) | (enumLiteral_10= 'java.util.List' ) ) )
            // InternalStateMachineDsl.g:983:2: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'java.lang.Boolean' ) | (enumLiteral_2= 'java.lang.Integer' ) | (enumLiteral_3= 'java.lang.Long' ) | (enumLiteral_4= 'java.lang.Float' ) | (enumLiteral_5= 'java.lang.Decimal' ) | (enumLiteral_6= 'java.lang.String' ) | (enumLiteral_7= 'java.lang.Date' ) | (enumLiteral_8= 'java.lang.DateTime' ) | (enumLiteral_9= 'java.lang.Time' ) | (enumLiteral_10= 'java.util.List' ) )
            {
            // InternalStateMachineDsl.g:983:2: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'java.lang.Boolean' ) | (enumLiteral_2= 'java.lang.Integer' ) | (enumLiteral_3= 'java.lang.Long' ) | (enumLiteral_4= 'java.lang.Float' ) | (enumLiteral_5= 'java.lang.Decimal' ) | (enumLiteral_6= 'java.lang.String' ) | (enumLiteral_7= 'java.lang.Date' ) | (enumLiteral_8= 'java.lang.DateTime' ) | (enumLiteral_9= 'java.lang.Time' ) | (enumLiteral_10= 'java.util.List' ) )
            int alt12=11;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt12=1;
                }
                break;
            case 31:
                {
                alt12=2;
                }
                break;
            case 32:
                {
                alt12=3;
                }
                break;
            case 33:
                {
                alt12=4;
                }
                break;
            case 34:
                {
                alt12=5;
                }
                break;
            case 35:
                {
                alt12=6;
                }
                break;
            case 36:
                {
                alt12=7;
                }
                break;
            case 37:
                {
                alt12=8;
                }
                break;
            case 38:
                {
                alt12=9;
                }
                break;
            case 39:
                {
                alt12=10;
                }
                break;
            case 40:
                {
                alt12=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalStateMachineDsl.g:984:3: (enumLiteral_0= 'NONE' )
                    {
                    // InternalStateMachineDsl.g:984:3: (enumLiteral_0= 'NONE' )
                    // InternalStateMachineDsl.g:985:4: enumLiteral_0= 'NONE'
                    {
                    enumLiteral_0=(Token)match(input,30,FOLLOW_2); 

                    				current = grammarAccess.getInternalTypeAccess().getNONEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getInternalTypeAccess().getNONEEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalStateMachineDsl.g:992:3: (enumLiteral_1= 'java.lang.Boolean' )
                    {
                    // InternalStateMachineDsl.g:992:3: (enumLiteral_1= 'java.lang.Boolean' )
                    // InternalStateMachineDsl.g:993:4: enumLiteral_1= 'java.lang.Boolean'
                    {
                    enumLiteral_1=(Token)match(input,31,FOLLOW_2); 

                    				current = grammarAccess.getInternalTypeAccess().getBOOLEANEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getInternalTypeAccess().getBOOLEANEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalStateMachineDsl.g:1000:3: (enumLiteral_2= 'java.lang.Integer' )
                    {
                    // InternalStateMachineDsl.g:1000:3: (enumLiteral_2= 'java.lang.Integer' )
                    // InternalStateMachineDsl.g:1001:4: enumLiteral_2= 'java.lang.Integer'
                    {
                    enumLiteral_2=(Token)match(input,32,FOLLOW_2); 

                    				current = grammarAccess.getInternalTypeAccess().getINTEGEREnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getInternalTypeAccess().getINTEGEREnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalStateMachineDsl.g:1008:3: (enumLiteral_3= 'java.lang.Long' )
                    {
                    // InternalStateMachineDsl.g:1008:3: (enumLiteral_3= 'java.lang.Long' )
                    // InternalStateMachineDsl.g:1009:4: enumLiteral_3= 'java.lang.Long'
                    {
                    enumLiteral_3=(Token)match(input,33,FOLLOW_2); 

                    				current = grammarAccess.getInternalTypeAccess().getLONGEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getInternalTypeAccess().getLONGEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalStateMachineDsl.g:1016:3: (enumLiteral_4= 'java.lang.Float' )
                    {
                    // InternalStateMachineDsl.g:1016:3: (enumLiteral_4= 'java.lang.Float' )
                    // InternalStateMachineDsl.g:1017:4: enumLiteral_4= 'java.lang.Float'
                    {
                    enumLiteral_4=(Token)match(input,34,FOLLOW_2); 

                    				current = grammarAccess.getInternalTypeAccess().getFLOATEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getInternalTypeAccess().getFLOATEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalStateMachineDsl.g:1024:3: (enumLiteral_5= 'java.lang.Decimal' )
                    {
                    // InternalStateMachineDsl.g:1024:3: (enumLiteral_5= 'java.lang.Decimal' )
                    // InternalStateMachineDsl.g:1025:4: enumLiteral_5= 'java.lang.Decimal'
                    {
                    enumLiteral_5=(Token)match(input,35,FOLLOW_2); 

                    				current = grammarAccess.getInternalTypeAccess().getDECIMALEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getInternalTypeAccess().getDECIMALEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalStateMachineDsl.g:1032:3: (enumLiteral_6= 'java.lang.String' )
                    {
                    // InternalStateMachineDsl.g:1032:3: (enumLiteral_6= 'java.lang.String' )
                    // InternalStateMachineDsl.g:1033:4: enumLiteral_6= 'java.lang.String'
                    {
                    enumLiteral_6=(Token)match(input,36,FOLLOW_2); 

                    				current = grammarAccess.getInternalTypeAccess().getSTRINGEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getInternalTypeAccess().getSTRINGEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalStateMachineDsl.g:1040:3: (enumLiteral_7= 'java.lang.Date' )
                    {
                    // InternalStateMachineDsl.g:1040:3: (enumLiteral_7= 'java.lang.Date' )
                    // InternalStateMachineDsl.g:1041:4: enumLiteral_7= 'java.lang.Date'
                    {
                    enumLiteral_7=(Token)match(input,37,FOLLOW_2); 

                    				current = grammarAccess.getInternalTypeAccess().getDATEEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getInternalTypeAccess().getDATEEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalStateMachineDsl.g:1048:3: (enumLiteral_8= 'java.lang.DateTime' )
                    {
                    // InternalStateMachineDsl.g:1048:3: (enumLiteral_8= 'java.lang.DateTime' )
                    // InternalStateMachineDsl.g:1049:4: enumLiteral_8= 'java.lang.DateTime'
                    {
                    enumLiteral_8=(Token)match(input,38,FOLLOW_2); 

                    				current = grammarAccess.getInternalTypeAccess().getDATETIMEEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getInternalTypeAccess().getDATETIMEEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalStateMachineDsl.g:1056:3: (enumLiteral_9= 'java.lang.Time' )
                    {
                    // InternalStateMachineDsl.g:1056:3: (enumLiteral_9= 'java.lang.Time' )
                    // InternalStateMachineDsl.g:1057:4: enumLiteral_9= 'java.lang.Time'
                    {
                    enumLiteral_9=(Token)match(input,39,FOLLOW_2); 

                    				current = grammarAccess.getInternalTypeAccess().getTIMEEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getInternalTypeAccess().getTIMEEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalStateMachineDsl.g:1064:3: (enumLiteral_10= 'java.util.List' )
                    {
                    // InternalStateMachineDsl.g:1064:3: (enumLiteral_10= 'java.util.List' )
                    // InternalStateMachineDsl.g:1065:4: enumLiteral_10= 'java.util.List'
                    {
                    enumLiteral_10=(Token)match(input,40,FOLLOW_2); 

                    				current = grammarAccess.getInternalTypeAccess().getLISTEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_10, grammarAccess.getInternalTypeAccess().getLISTEnumLiteralDeclaration_10());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInternalType"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000004802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000006800L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000004002000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000102000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000202000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000003002000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000002002000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000008002000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x000001FFC0000020L});

}
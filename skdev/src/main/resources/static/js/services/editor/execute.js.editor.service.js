(function() {
	'use strict';

	angular.module("skdevMD").factory('executeJSEditorSV', executeJSEditorSV);

	executeJSEditorSV.$inject = [ '$log', '$mdToast' ];

	/**
	 * 
	 * @param $log
	 * @param $mdToast
	 * @returns
	 */
	function executeJSEditorSV($log, $mdToast) {
		$log.debug('[executeJSEditorSV] Inicializando... ');

		var editor = {};

		var service = {
			init : init,
			setValue : setValue,
			getValue : getValue,
			getEditor: getEditor
		};

		function init() {
			$log.debug('[executeJSEditorSV] Inicializando editor executeJS...');
			editor = CodeMirror(document.getElementById('executeJSEditor'), {
				mode : "javascript",
				lineNumbers : true,
				gutters : [ "CodeMirror-lint-markers" ],
				lint : true,
				autoCloseBrackets : true,
				extraKeys : {
					"Ctrl-Space" : "autocomplete"
				},
				matchBrackets : false,
				theme : 'eclipse',
				indentUnit : 4,
				styleActiveLine : true
			});
			editor.setSize('100%', '100%');
		}

		function setValue(text) {
			editor.setValue(text);
		}

		function getValue() {
			return editor.getValue();
		}
		
		function getEditor() {
			return editor;
		}

		return service;
	}

})();
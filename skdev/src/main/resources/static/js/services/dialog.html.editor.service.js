(function() {
	'use strict';

	angular.module("skdevMD").factory('dialogHTMLEditorSV', dialogHTMLEditorSV);

	dialogHTMLEditorSV.$inject = [ '$log', '$mdToast' ];

	/**
	 * 
	 * @param $log
	 * @param $mdToast
	 * @returns
	 */
	function dialogHTMLEditorSV($log, $mdToast) {
		$log.debug('[dialogHTMLEditorSV] Inicializando... ');

		var editor = {};

		var service = {
			init : init,
			setValue : setValue,
			getValue : getValue,
			getEditor: getEditor
		};

		function init() {
			$log.debug('[dialogHTMLEditorSV] Inicializando editor dialogHTML...');
			editor = CodeMirror(document.getElementById('dialogHTMLEditor'), {
				mode: "text/html",
				lineNumbers : true,
				autoCloseTags : true,
				gutters : [ "CodeMirror-lint-markers" ],
				theme : 'eclipse',
				indentUnit : 4,
				matchTags: {bothTags: true},
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
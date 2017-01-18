(function() {
	'use strict';

	angular.module('skdevMD').controller('ActionCT', ActionCT);

	ActionCT.$inject = [ '$scope', '$log', '$mdDialog', 'eAction', '$http', 'projectSV', '$location', 'executeJSTemplateSV',
			'executeJSProjectSV', 'executeJSConsoleSV' ];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @returns
	 */
	function ActionCT($scope, $log, $mdDialog, eAction, $http, projectSV, $location, executeJSTemplateSV, executeJSProjectSV,
			executeJSConsoleSV) {
		$log.debug('[ActionCT] Inicializando...');
		var self = this;

		var origin = new URI($location.absUrl());

		var editors = {};

		$scope.cancel = cancel;

		self.load = load;

		self.options = {};

		$scope.$values = {
			project : {}
		};

		$scope.execute = execute;
		
		$scope.getProjects = getProjects;
		
		var getProjectsCache;

		function cancel() {
			$mdDialog.cancel();
		}

		function load(id, endpoint) {
			$log.debug('[ActionCT] ProjectName: ' + projectSV.getSelectedProject().name);
			var loadURL = origin.segment([ "skdev", "api", "projects", projectSV.getSelectedProject().name, endpoint ]).href();
			$log.debug('[ActionCT] load: ' + loadURL);
			$http.get(loadURL).then(function(res) {
				self.options[id] = res.data;
			});
		}
		
		function getProjects() {
			if(angular.isUndefined(getProjectsCache)) {
				getProjectsCache = [];
				var getProjectsURL = origin.segment([ 'skdev', 'api', 'projects' ]).href();
				$log.debug('[ActionCT] getProjects() : ' + getProjectsURL);
				$http.get(getProjectsURL).then(function(res) {
					getProjectsCache = res.data;
				});
			}
			return getProjectsCache;
		}

		function execute() {
			var parentEl = angular.element(document.body);
			$mdDialog.show({
				parent : parentEl,
				templateUrl : '/skdev/partials/action.console.dialog.html',
				controller : 'ActionConsoleCT',
				controllerAs : 'actionConsoleCT',
				clickOutsideToClose : false,
				onComplete : function(scope, element) {
					$log.debug('[ActionCT] execute');

					/*
					 * Inicializa as variáveis do executeJS
					 */
					executeJSTemplateSV.setTemplates(eAction.templates);
					var $values = $scope.$values;
					var $template = executeJSTemplateSV;
					var $project = executeJSProjectSV;
					var $console = executeJSConsoleSV;

					var executeFn = new Function('$values', '$template', '$project', '$console', eAction.executeJS);
					try {
						angular.bind(this, executeFn, $values, $template, $project, $console)();
					} catch(err) {
						console.log(err);
						executeJSConsoleSV.error(err.message);
					}
				}
			});
		}
	}
})();
